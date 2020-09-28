package com.example.payment.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.payment.center.config.MiniProgramConfig;
import com.example.payment.center.dao.*;
import com.example.payment.center.manual.*;
import com.example.payment.center.model.*;
import com.example.payment.center.service.BalanceService;
import com.example.payment.center.util.PayUtil;
import com.example.payment.center.service.AddStockService;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author shihao
 * @Title: MiniPaymentOrderController
 * @ProjectName Second-order-center
 * @Description: 小程序微信支付
 * @date Created in
 * @Version: $
 */
@CrossOrigin
@RestController
@RequestMapping("/payment")
@Api
public class MiniPaymentOrderController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MiniProgramConfig miniProgramConfig;
//    auth
    @Autowired
    private SecondAuthMapper secondAuthMapper;
    //支付订单
    @Autowired
    private SecondPayOrderMapper secondPayOrderMapper;
    //订单
    @Autowired
    private SecondOrderMapper secondOrderMapper;
    //订单详情
    @Autowired
    private SecondOrderDetailMapper secondOrderDetailMapper;
    //支付配置
    @Autowired
    private SecondBossSettingMapper secondBossSettingMapper;
    //微信支付流水
    @Autowired
    private SecondTransactionFlowMapper secondTransactionFlowMapper;
    @Autowired
    HttpServletRequest req;
    //物品
    @Autowired
    private SecondGoodsMapper secondGoodsMapper;
    //添加库存
    @Autowired
    private AddStockService addStockService;
    //商品
    @Autowired
    private SecondProductMapper secondProductMapper;
    //店铺
    @Autowired
    private SecondStoreMapper secondStoreMapper;
    //店铺余额
    @Autowired
    private SecondStoreBalanceMapper secondStoreBalanceMapper;
    //
    @Autowired
    private BalanceService balanceService;
    //余额明细
    @Autowired
    private SecondStoreBalanceDetailMapper secondStoreBalanceDetailMapper;
    @ApiOperation(value = "支付订单", notes = "")
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer") })
    public ResponseEntity<JSONObject> payment(Integer userId, Integer payOrderId) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        SecondBossSettingExample secondBossSettingExample = new SecondBossSettingExample();
        secondBossSettingExample.createCriteria().andBossIdEqualTo(1)
                .andBossTypeEqualTo(Authentication.LoginType.USERWX.getState());
        List<SecondBossSetting> secondBossSettings =//商家支付配置
        secondBossSettingMapper.selectByExample(secondBossSettingExample);
//        MiniProgramConfig miniProgramConfig = new MiniProgramConfig();
        miniProgramConfig.setAppId(secondBossSettings.get(0).getAppId());
        miniProgramConfig.setPath(secondBossSettings.get(0).getApiclientCert());
        miniProgramConfig.setPayKey(secondBossSettings.get(0).getPayKey());
        miniProgramConfig.setMchId(secondBossSettings.get(0).getMchId());
        SecondAuthExample secondAuthExample = new SecondAuthExample();
        secondAuthExample.createCriteria().andUserIdEqualTo(userId)
                .andAuthStatusEqualTo((byte) 0)
                .andLoginTypeEqualTo(Authentication.LoginType.USERWX.getState());
        List<SecondAuth> secondAuth = secondAuthMapper.selectByExample(secondAuthExample);
        SecondPayOrder payOrder= secondPayOrderMapper.selectByPrimaryKey(payOrderId);
        SecondOrderExample hfOrderExample = new SecondOrderExample();
        hfOrderExample.createCriteria().andPayOrderIdEqualTo(payOrder.getId());

        Map<String, String> resp = null;
        if (PaymentTypeEnum.getPaymentTypeEnum(secondOrderMapper.selectByExample(hfOrderExample).get(0).getPaymentName()).equals(PaymentTypeEnum.WECHART)) {
            resp = wxPay(miniProgramConfig,secondAuth.get(0), payOrder);
        }else if (PaymentTypeEnum.getPaymentTypeEnum(secondOrderMapper.selectByExample(hfOrderExample).get(0).getPaymentName()).equals(PaymentTypeEnum.BALANCE)){
            resp = balancePay(secondAuth.get(0), payOrder);
        }
        System.out.println(resp);
        return builder.body(ResponseUtils.getResponseBody(resp));
    }
    //微信小程序支付
    private Map<String, String> wxPay(MiniProgramConfig miniProgramConfig,SecondAuth hfUser, SecondPayOrder payOrder) throws Exception {
//		MiniProgramConfig config = new MiniProgramConfig();
        System.out.println(miniProgramConfig.getAppID());
        Map<String, String> data = getWxPayData(miniProgramConfig, hfUser.getAuthKey(), String.valueOf(payOrder.getId()),payOrder.getAmount());

        logger.info(JSONObject.toJSONString(data));
        WXPay wxpay = new WXPay(miniProgramConfig);
        Map<String, String> resp = wxpay.unifiedOrder(data);
        logger.info(JSONObject.toJSONString(resp));
        if ("SUCCESS".equals(resp.get("return_code"))) {
            Map<String, String> reData = new HashMap<>();
            reData.put("appId", miniProgramConfig.getAppID());
            reData.put("nonceStr", resp.get("nonce_str"));
            String newPackage = "prepay_id=" + resp.get("prepay_id");
            reData.put("package", newPackage);
            reData.put("signType", "MD5");
            reData.put("timeStamp", String.valueOf(System.currentTimeMillis() / 1000));

            String newSign = WXPayUtil.generateSignature(reData, miniProgramConfig.getKey());
            resp.put("paySign", newSign);
            resp.put("package", reData.get("package"));
            resp.put("signType", reData.get("signType"));
            resp.put("timeStamp", reData.get("timeStamp"));
            recordTransactionFlow(hfUser, payOrder, data, reData);
            return resp;
        } else {
            throw new Exception(resp.get("return_msg"));
        }

    }

    /**
     * 余额支付
     * @param hfUser
     * @param payOrder
     * @return
     * @throws Exception
     */
    private Map<String, String> balancePay(SecondAuth hfUser, SecondPayOrder payOrder) throws Exception {
        Map<String,String> map = new HashMap<>();
        SecondStoreExample secondStoreExample = new SecondStoreExample();
        secondStoreExample.createCriteria().andUserIdEqualTo(hfUser.getUserId())
                .andIsDeletedEqualTo((short) 0)
                .andSecondStatusEqualTo(0);
        List<SecondStore> secondStores =
        secondStoreMapper.selectByExample(secondStoreExample);
        SecondStoreBalanceExample secondStoreBalanceExample = new SecondStoreBalanceExample();
        secondStoreBalanceExample.createCriteria().andUserIdEqualTo(hfUser.getUserId())
                .andStoreIdEqualTo(secondStores.get(0).getId())
                .andIsDeletedEqualTo((short) 0);
        List<SecondStoreBalance> secondStoreBalances =
                secondStoreBalanceMapper.selectByExample(secondStoreBalanceExample);
        if (secondStoreBalances.size()==0){
            SecondStoreBalance secondStoreBalance = new SecondStoreBalance();
            secondStoreBalance.setUserId(hfUser.getUserId());
            secondStoreBalance.setStoreId(secondStores.get(0).getId());
            secondStoreBalance.setBalanceType(BanlaceEnum.Relation.MONEY.getState());
            secondStoreBalance.setSecondBalance(0);
            secondStoreBalance.setCreateTime(LocalDateTime.now());
            secondStoreBalance.setModifyTime(LocalDateTime.now());
            secondStoreBalance.setIsDeleted((short) 0);
            secondStoreBalanceMapper.insertSelective(secondStoreBalance);
            map.put("statusCode","504");
            map.put("status","return_msg");
            return map;
        }else {
           int a = balanceService.addStock(hfUser.getUserId(),secondStores.get(0).getId(),
                    BanlaceEnum.Relation.MONEY.getState(),payOrder.getAmount());
           if (a<1){
               map.put("statusCode","504");
               map.put("status","return_msg");
               return map;
           }
        }
        map.put("statusCode","200");
        map.put("status","succeed");
        return map;
    }
    /**
     *
     * @param config
     * @param openId
     * @param orderCode
     * @param Amount
     * @return
     * @throws Exception
     */
    private Map<String, String> getWxPayData(MiniProgramConfig config, String openId, String orderCode,Integer Amount)
            throws Exception {
        Map<String, String> data = new HashMap<>();
        data.put("appid", config.getAppID());
        data.put("mch_id", config.getMchID());
        data.put("body", "订单支付");
        data.put("out_trade_no", orderCode);
        data.put("device_info", req.getRemoteHost());
        data.put("fee_type", "CNY");
        data.put("total_fee", String.valueOf(Amount));
        data.put("spbill_create_ip", req.getRemoteAddr());
        data.put("notify_url", "https://http://39.100.237.144:7005/payment/payment/handleWxpay");
        data.put("trade_type", "JSAPI");
        data.put("openid", openId);
        String sign = WXPayUtil.generateSignature(data, config.getKey());
        data.put("sign", sign);
        logger.info(JSONObject.toJSONString(data));
        return data;
    }

    private void recordTransactionFlow(SecondAuth hfUser, SecondPayOrder payOrder, Map<String, String> data,
                                       Map<String, String> reData) {
        SecondOrderExample secondOrderExample = new SecondOrderExample();
        secondOrderExample.createCriteria().andPayOrderIdEqualTo(payOrder.getId());
        List<SecondOrder> hfOrders= secondOrderMapper.selectByExample(secondOrderExample);

        SecondTransactionFlowExample e = new SecondTransactionFlowExample();
        e.createCriteria().andTradeTypeEqualTo(hfOrders.get(0).getOrderType()).andOutTradeNoEqualTo(data.get("out_trade_no"))
                .andHfStatusEqualTo(TansactionFlowStatusEnum.PROCESS.getStatus());
        List<SecondTransactionFlow> hfTansactionFlows = secondTransactionFlowMapper.selectByExample(e);

        if (hfTansactionFlows.isEmpty()) {
            SecondTransactionFlow t = completeHfTansactionFlow(new SecondTransactionFlow(), hfUser, payOrder, data, reData);
            secondTransactionFlowMapper.insertSelective(t);
        } else {
            SecondTransactionFlow t = completeHfTansactionFlow(hfTansactionFlows.get(0), hfUser, payOrder, data, reData);
            secondTransactionFlowMapper.updateByPrimaryKey(t);
        }
    }

    private SecondTransactionFlow completeHfTansactionFlow(SecondTransactionFlow t, SecondAuth hfUser, SecondPayOrder payOrder,
                                                      Map<String, String> data, Map<String, String> reData) {
        LocalDateTime current = LocalDateTime.now();
        SecondOrderExample secondOrderExample = new SecondOrderExample();
        secondOrderExample.createCriteria().andPayOrderIdEqualTo(payOrder.getId());
        List<SecondOrder> HfOrders= secondOrderMapper.selectByExample(secondOrderExample);
        t.setAppId(data.get("appid"));
        t.setCreateDate(current);
        t.setDeviceInfo(data.get("device_info"));
        t.setFeeType(data.get("fee_type"));
        t.setMchId(data.get("mch_id"));
        t.setModifyDate(current);
        t.setNotifyUrl(data.get("notify_url"));
        t.setOpenId(hfUser.getAuthKey());
        t.setOutTradeNo(data.get("out_trade_no"));
        t.setSigntype(reData.get("signType"));
        t.setSpbillCreateIp(data.get("spbill_create_ip"));
        t.setTotalFee(data.get("total_fee"));
        t.setTradeType(data.get("trade_type"));
        t.setTransactionType(HfOrders.get(0).getOrderType());
        t.setHfStatus(TansactionFlowStatusEnum.PROCESS.getStatus());
        t.setUserId(hfUser.getUserId());
        t.setWechartBody(data.get("body"));
        t.setWechartPackage("package");
        return t;
    }
/**
 * 完成支付订单
 */
@ApiOperation(value = "完成支付", notes = "")
@RequestMapping(value = "/complete", method = RequestMethod.GET)
@ApiImplicitParams({
//			@ApiImplicitParam(paramType = "query", name = "outTradeNo", value = "订单id", required = true, type = "String"),
//        @ApiImplicitParam(paramType = "query", name = "transactionType", value = "订单id", required = true, type = "String"),
        })
@Transactional(rollbackFor = {RuntimeException.class, Error.class})
public ResponseEntity<JSONObject> completePaymentAfter(
        Integer payOrderId)
        throws Exception {
    ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
    SecondPayOrder payOrder = secondPayOrderMapper.selectByPrimaryKey(payOrderId);
    SecondOrderExample secondOrderExample = new SecondOrderExample();
    secondOrderExample.createCriteria().andPayOrderIdEqualTo(payOrderId);
    List<SecondOrder> secondOrders= secondOrderMapper.selectByExample(secondOrderExample);
    for (SecondOrder secondOrder:secondOrders){
        if (PaymentTypeEnum.getPaymentTypeEnum(secondOrder.getPaymentName()).equals(PaymentTypeEnum.WECHART)) {
            SecondTransactionFlowExample e = new SecondTransactionFlowExample();
            e.createCriteria().andOutTradeNoEqualTo(String.valueOf(payOrder.getId()));
            List<SecondTransactionFlow> secondTransactionFlows = secondTransactionFlowMapper.selectByExample(e);
            if (!secondTransactionFlows.isEmpty()) {
                SecondTransactionFlow hfTansactionFlow = secondTransactionFlows.get(0);
                hfTansactionFlow.setModifyDate(LocalDateTime.now());
                hfTansactionFlow.setHfStatus(TansactionFlowStatusEnum.COMPLETE.getStatus());
                secondTransactionFlowMapper.updateByPrimaryKeySelective(hfTansactionFlow);
//                if (OrderTypeEnum.RECHAEGE_ORDER.getOrderType().equals(secondOrder.getOrderType())){
                    SecondOrderExample secondOrderExample1 = new SecondOrderExample();
                    secondOrderExample1.createCriteria().andOrderCodeEqualTo(secondOrder.getOrderCode());
                    SecondOrder secondOrder1 = new SecondOrder();
                    secondOrder1.setOrderStatus(OrderEnum.OrderStatus.PROCESS.getOrderStatus());
                    secondOrder1.setModifyTime(LocalDateTime.now());
                    secondOrder1.setPayStatus(1);
                    secondOrderMapper.updateByExampleSelective(secondOrder1,secondOrderExample1);
                    SecondOrderDetail secondOrderDetail = new SecondOrderDetail();
                    secondOrderDetail.setDetailStatus(OrderEnum.OrderStatus.PROCESS.getOrderStatus());
                    SecondOrderDetailExample example = new SecondOrderDetailExample();
                    example.createCriteria().andOrderIdEqualTo(secondOrder.getId());
                    secondOrderDetailMapper.updateByExampleSelective(secondOrderDetail,example);
//                }
					return builder.body(ResponseUtils.getResponseBody(hfTansactionFlow));
            } else {
                throw new Exception("交易柳树不存在, 或者已完成支付");
            }
        } else if (PaymentTypeEnum.getPaymentTypeEnum(secondOrder.getPaymentName()).equals(PaymentTypeEnum.BALANCE)){
            SecondOrderExample secondOrderExample1 = new SecondOrderExample();
            secondOrderExample1.createCriteria().andOrderCodeEqualTo(secondOrder.getOrderCode());
            SecondOrder secondOrder1 = new SecondOrder();
            secondOrder1.setOrderStatus(OrderEnum.OrderStatus.PROCESS.getOrderStatus());
            secondOrder1.setModifyTime(LocalDateTime.now());
            secondOrder1.setPayStatus(1);
            secondOrderMapper.updateByExampleSelective(secondOrder1,secondOrderExample1);
            SecondOrderDetail secondOrderDetail = new SecondOrderDetail();
            secondOrderDetail.setDetailStatus(OrderEnum.OrderStatus.PROCESS.getOrderStatus());
            SecondOrderDetailExample example = new SecondOrderDetailExample();
            example.createCriteria().andOrderIdEqualTo(secondOrder.getId());
            secondOrderDetailMapper.updateByExampleSelective(secondOrderDetail,example);
        }
    }
    return builder.body(ResponseUtils.getResponseBody(0));
}
    /**
     * 未完成支付
     */
    @ApiOperation(value = "未完成支付", notes = "")
    @RequestMapping(value = "/noComplete", method = RequestMethod.GET)
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> noComplete(
            Integer payOrderId)
            throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        SecondOrderExample secondOrderExample = new SecondOrderExample();
        secondOrderExample.createCriteria().andPayOrderIdEqualTo(payOrderId);
        List<SecondOrder> secondOrders= secondOrderMapper.selectByExample(secondOrderExample);
        secondOrders.forEach(secondOrder -> {
            SecondOrderDetailExample secondOrderDetailExample = new SecondOrderDetailExample();
            secondOrderDetailExample.createCriteria().andOrderIdEqualTo(secondOrder.getId());
            List<SecondOrderDetail> secondOrderDetails =
            secondOrderDetailMapper.selectByExample(secondOrderDetailExample);
            secondOrderDetails.forEach(secondOrderDetail -> {
                addStockService.addStock(secondOrderDetail.getGoodsId(),secondOrderDetail.getQuantity());
                SecondGoods secondGoods = secondGoodsMapper.selectByPrimaryKey(secondOrderDetail.getGoodsId());
                SecondProduct secondProduct = secondProductMapper.selectByPrimaryKey(secondGoods.getProductId());
                secondProduct.setProductState(ProductEnum.ProductState.SELL.getState());
                secondProductMapper.updateByPrimaryKeySelective(secondProduct);
            });
        });
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    /**
     * 退款
     * @param
     * @param
     * @throws Exception
     */
    @ApiOperation(value = "退款订单", notes = "")
    @RequestMapping(value = "/refund", method = RequestMethod.GET)
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "outTradeNo", value = "订单id", required = true, type = "orderCode"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer") })
    public ResponseEntity<JSONObject> refund( Integer userId,Integer payOrderId,String orderCode) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        SecondBossSettingExample secondBossSettingExample = new SecondBossSettingExample();
        secondBossSettingExample.createCriteria().andBossIdEqualTo(1)
                .andBossTypeEqualTo(Authentication.LoginType.USERWX.getState());
        List<SecondBossSetting> secondBossSettings =//商家支付配置
                secondBossSettingMapper.selectByExample(secondBossSettingExample);
//        MiniProgramConfig miniProgramConfig = new MiniProgramConfig();
        miniProgramConfig.setAppId(secondBossSettings.get(0).getAppId());
        miniProgramConfig.setPath(secondBossSettings.get(0).getApiclientCert());
        miniProgramConfig.setPayKey(secondBossSettings.get(0).getPayKey());
        miniProgramConfig.setMchId(secondBossSettings.get(0).getMchId());
//		alipayConfig.setBossId(2);
        List<SecondOrder> secondOrders = new ArrayList<>();
        SecondOrderExample secondOrderExample1 = new SecondOrderExample();
        secondOrderExample1.createCriteria().andOrderCodeEqualTo(orderCode);
        secondOrders = secondOrderMapper.selectByExample(secondOrderExample1);

        SecondPayOrder payOrder = secondPayOrderMapper.selectByPrimaryKey(payOrderId);
        SecondAuth hfUser = secondAuthMapper.selectByPrimaryKey(userId);
        if (secondOrders.get(0).getPaymentName().equals("wechart") && secondOrders.get(0).getPaymentType().equals(0)){
//			MiniProgramConfig config = new MiniProgramConfig();
            WXPay wxpay = new WXPay(miniProgramConfig);
            Map<String, String> data = new HashMap<>();
            data.put("appid", miniProgramConfig.getAppID());
            data.put("mch_id", miniProgramConfig.getMchID());
            data.put("device_info", req.getRemoteHost());
            data.put("fee_type", "CNY");
            data.put("total_fee", String.valueOf(payOrder.getAmount()));

            data.put("spbill_create_ip", req.getRemoteAddr());
            data.put("notify_url", "https://www.tjsichuang.cn:1443/api/payment/hf-payment/handleWxpay");

            data.put("out_trade_no", String.valueOf(payOrder.getId()));
            data.put("op_user_id", miniProgramConfig.getMchID());
            data.put("refund_fee_type", "CNY");
            if (secondOrders!=null){
                System.out.println(secondOrders.get(0).getAmount());
                data.put("refund_fee", String.valueOf(secondOrders.get(0).getAmount()));
            }else {
                System.out.println(payOrder.getAmount());
                data.put("refund_fee", String.valueOf(payOrder.getAmount()));
            }

            data.put("out_refund_no", UUID.randomUUID().toString().replaceAll("-", ""));
            String sign = WXPayUtil.generateSignature(data, miniProgramConfig.getKey());
            data.put("sign", sign);
            logger.info(JSONObject.toJSONString(data));

            Map<String, String> resp = wxpay.refund(data);
            logger.info(JSONObject.toJSONString(resp));
            if ("SUCCESS".equals(resp.get("return_code"))) {
                LocalDateTime current = LocalDateTime.now();

                SecondTransactionFlow t = new SecondTransactionFlow();
                t.setAppId(miniProgramConfig.getAppID());
                t.setCreateDate(current);
                t.setDeviceInfo(req.getRemoteHost());
                t.setFeeType(data.get("refund_fee_type"));
                t.setMchId(miniProgramConfig.getMchID());
                t.setModifyDate(current);
                t.setOpenId(hfUser.getAuthKey());
                t.setOutTradeNo(data.get("out_trade_no"));
                t.setSpbillCreateIp(req.getRemoteAddr());
                t.setTotalFee(data.get("refund_fee"));
                t.setOutRefundNo(data.get("out_refund_no"));
                t.setTransactionType("rerundOrder");
                t.setHfStatus(TansactionFlowStatusEnum.COMPLETE.getStatus());
                t.setUserId(hfUser.getUserId());
            }

            return builder.body(ResponseUtils.getResponseBody(resp));
        } else if (secondOrders.get(0).getPaymentName().equals("balance") && secondOrders.get(0).getPaymentType().equals(0)) {
            SecondStoreExample secondStoreExample = new SecondStoreExample();
            secondStoreExample.createCriteria().andUserIdEqualTo(secondOrders.get(0).getUserId())
                    .andIsDeletedEqualTo((short) 0);
            List<SecondStore> secondStore = secondStoreMapper.selectByExample(secondStoreExample);
            balanceService.addBalance(secondStore.get(0).getId(),
                    BanlaceEnum.Relation.MONEY.getState(),
                    secondOrders.get(0).getAmount());
            //余额明细
            SecondStoreBalanceDetail secondStoreBalanceDetail = new SecondStoreBalanceDetail();
            secondStoreBalanceDetail.setUserId(secondOrders.get(0).getUserId());
            secondStoreBalanceDetail.setStoreId(secondStore.get(0).getId());
            secondStoreBalanceDetail.setAmount(secondOrders.get(0).getAmount());
            secondStoreBalanceDetail.setDetailType(BanlaceEnum.Relation.MONEY.getState());
            secondStoreBalanceDetail.setIncomeExpenses(BanlaceEnum.incomeExpenses.PUT.getState());
            secondStoreBalanceDetail.setCreateTime(LocalDateTime.now());
            secondStoreBalanceDetail.setModifyTime(LocalDateTime.now());
            secondStoreBalanceDetail.setIsDeleted((short) 0);
            secondStoreBalanceDetailMapper.insertSelective(secondStoreBalanceDetail);
        }
        return builder.body(ResponseUtils.getResponseBody(1));
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @ApiOperation(value = "訂單支付后處理", notes = "訂單支付后處理")
    @RequestMapping(value = "/handleWxpay", method = RequestMethod.GET)
    public void refund(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		MiniProgramConfig config = new MiniProgramConfig();
//        MiniProgramConfig miniProgramConfig = new MiniProgramConfig();
        BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        // sb为微信返回的xml
        String notityXml = sb.toString();
        String resXml = "";
        logger.info("接收到的报文：" + notityXml);

        Map map = PayUtil.doXMLParse(notityXml);

        String returnCode = (String) map.get("return_code");
        if ("SUCCESS".equals(returnCode)) {
            // hfOrderDao.updateHfOrderStatus(out_trade_no,
            // OrderStatus.PROCESS.getOrderStatus(), LocalDateTime.now());
            Map<String, String> validParams = PayUtil.paraFilter(map); // 回调验签时需要去除sign和空值参数
            String validStr = PayUtil.createLinkString(validParams);// 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
            String sign = PayUtil.sign(validStr, miniProgramConfig.getKey(), "utf-8").toUpperCase();// 拼装生成服务器端验证的签名
            // 因为微信回调会有八次之多,所以当第一次回调成功了,那么我们就不再执行逻辑了

            // 根据微信官网的介绍，此处不仅对回调的参数进行验签，还需要对返回的金额与系统订单的金额进行比对等
            if (sign.equals(map.get("sign"))) {
                /** 此处添加自己的业务逻辑代码start **/
                // bla bla bla....
                /** 此处添加自己的业务逻辑代码end **/
                // 通知微信服务器已经支付成功
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            } else {
                System.out.println("微信支付回调失败!签名不一致");
            }
        } else {
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
        }
        System.out.println(resXml);
        logger.info("微信支付回调数据结束");

        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        out.write(resXml.getBytes());
        out.flush();
        out.close();
    }
//    @ApiOperation(value = "测试", notes = "")
//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public ResponseEntity<JSONObject> payment() throws Exception {
//        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
//        miniProgramConfig.setAppId("123456");
//        miniProgramConfig.setMchId("1234567");
//        miniProgramConfig.setPath("12345678");
//        miniProgramConfig.setPayKey("123456789");
//        System.out.println(miniProgramConfig.getAppID());
//        System.out.println(miniProgramConfig.getMchID());
//        return builder.body(ResponseUtils.getResponseBody(0));
//    }

}
