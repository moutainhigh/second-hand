package com.example.payment.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.payment.center.config.MiniProgramConfig;
import com.example.payment.center.dao.SecondAuthMapper;
import com.example.payment.center.dao.SecondOrderMapper;
import com.example.payment.center.dao.SecondPayOrderMapper;
import com.example.payment.center.manual.Login;
import com.example.payment.center.manual.PaymentTypeEnum;
import com.example.payment.center.model.SecondAuth;
import com.example.payment.center.model.SecondAuthExample;
import com.example.payment.center.model.SecondOrderExample;
import com.example.payment.center.model.SecondPayOrder;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping("/payment/")
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

    @Autowired
    HttpServletRequest req;
    @ApiOperation(value = "支付订单", notes = "")
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer") })
    public ResponseEntity<JSONObject> payment(Integer userId, Integer payOrderId) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        SecondAuthExample secondAuthExample = new SecondAuthExample();
        secondAuthExample.createCriteria().andUserIdEqualTo(userId)
                .andAuthStatusEqualTo((byte) 0)
                .andLoginTypeEqualTo(Login.WECHART.getPaymentTypeName());
        List<SecondAuth> secondAuth = secondAuthMapper.selectByExample(secondAuthExample);
        SecondPayOrder payOrder= secondPayOrderMapper.selectByPrimaryKey(payOrderId);
        SecondOrderExample hfOrderExample = new SecondOrderExample();
        hfOrderExample.createCriteria().andPayOrderIdEqualTo(payOrder.getId());

        Map<String, String> resp = null;
        if (PaymentTypeEnum.getPaymentTypeEnum(secondOrderMapper.selectByExample(hfOrderExample).get(0).getPaymentName()).equals(PaymentTypeEnum.WECHART)) {
            resp = wxPay(secondAuth.get(0), payOrder);
        }
        System.out.println(resp);
        return builder.body(ResponseUtils.getResponseBody(resp));
    }
    //微信小程序支付
    private Map<String, String> wxPay(SecondAuth hfUser, SecondPayOrder payOrder) throws Exception {
//		MiniProgramConfig config = new MiniProgramConfig();
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
//            recordTransactionFlow(hfUser, payOrder, data, reData);
            return resp;
        } else {
            throw new Exception(resp.get("return_msg"));
        }

    }

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
        data.put("notify_url", "https://www.tjsichuang.cn:1443/api/payment/hf-payment/handleWxpay");
        data.put("trade_type", "JSAPI");
        data.put("openid", openId);
        String sign = WXPayUtil.generateSignature(data, config.getKey());
        data.put("sign", sign);
        logger.info(JSONObject.toJSONString(data));
        return data;
    }
}
