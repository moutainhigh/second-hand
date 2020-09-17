package com.example.payment.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.payment.center.dao.*;
import com.example.payment.center.manual.Authentication;
import com.example.payment.center.manual.BanlaceEnum;
import com.example.payment.center.manual.SecondWithdrawalList;
import com.example.payment.center.manual.WithdrawalEnum;
import com.example.payment.center.manual.dao.BalanceMapper;
import com.example.payment.center.manual.dao.SonBalanceMapper;
import com.example.payment.center.model.*;
import com.example.payment.center.service.BalanceService;
import com.example.payment.center.service.SonBalanceService;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shihao
 * @Title: WithdrawalController
 * @ProjectName Second-order-center
 * @Description: 提现
 * @date Created in
 * @Version: $
 */
@CrossOrigin
@RestController
@RequestMapping("/Withdrawal")
@Api
public class WithdrawalController {

    /**
     * 订单号
     */
    private static final FastDateFormat pattern = FastDateFormat.getInstance("yyyyMMddHHmmss");
    private static final AtomicInteger atomicInteger = new AtomicInteger(1);
    private static ThreadLocal<StringBuilder> threadLocal = new ThreadLocal<StringBuilder>();
    public static String getC(String lock) {
        lock = Objects.isNull(lock) ? UUID.randomUUID().toString() : lock;
        StringBuilder builder = new StringBuilder(pattern.format(Instant.now().toEpochMilli()));// 取系统当前时间作为订单号前半部分
        builder.append(Math.abs(lock.hashCode()));// HASH-CODE
        builder.append(atomicInteger.getAndIncrement());// 自增顺序
        threadLocal.set(builder);
        return threadLocal.get().toString();
    }
    //店铺余额
    @Autowired
    private SecondStoreBalanceMapper secondStoreBalanceMapper;
    //商家配置
    @Autowired
    private SecondBossMapper secondBossMapper;
    //扣除余额
    @Autowired
    private BalanceService balanceService;
    //提现
    @Autowired
    private SecondWithdrawalMapper secondWithdrawalMapper;
    //店铺余额流水
    @Autowired
    private SecondStoreBalanceDetailMapper secondStoreBalanceDetailMapper;
    //查询认证消息
    @Autowired
    private SecondAuthenticationMapper secondAuthenticationMapper;
    //子站点和用户关系
    @Autowired
    private SecondUserSonMapper secondUserSonMapper;
    //子站点
    @Autowired
    private SecondSonMapper secondSonMapper;
    @Autowired
    private SonBalanceService sonBalanceService;
    //用户
    @Autowired
    private SecondUserMapper secondUserMapper;
    //店铺
    @Autowired
    private SecondStoreMapper secondStoreMapper;
    //取款方法
    @Autowired
    private SecondWithdrawalMethodMapper secondWithdrawalMethodMapper;
    @RequestMapping(path = "/addWithdrawal", method = RequestMethod.POST)
    @ApiOperation(value = "申请提现", notes = "申请提现")
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "source", value = "发起提现来源,user,store,son", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "phone", value = "手机号", required = true, type = "secondWithdrawal"),
            @ApiImplicitParam(paramType = "query", name = "withdrawalMoney", value = "取款金额", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "withdrawalAccount", value = "取款账号", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "withdrawalName", value = "姓名", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "methodId", value = "取款方式id", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "storeId", value = "店铺id", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "sonId", value = "子站点id", required = true, type = "String"),
    })
    public ResponseEntity<JSONObject> addWithdrawal(@RequestParam(value = "source", required = false) String source,
                                                    @RequestParam(value = "phone", required = false) String phone,
                                                    @RequestParam(value = "withdrawalMoney", required = false) Integer withdrawalMoney,
                                                    @RequestParam(value = "withdrawalAccount", required = false) String withdrawalAccount,
                                                    @RequestParam(value = "withdrawalName", required = false) String withdrawalName,
                                                    @RequestParam(value = "methodId", required = false) Integer methodId,
                                                    @RequestParam(value = "storeId", required = false) Integer storeId,
                                                    @RequestParam(value = "userId", required = false) Integer userId,
                                                    @RequestParam(value = "sonId", required = false) Integer sonId,
                                                    HttpServletResponse response) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondStoreBalanceExample secondStoreBalanceExample = new SecondStoreBalanceExample();
        secondStoreBalanceExample.createCriteria().andStoreIdEqualTo(storeId)
                .andBalanceTypeEqualTo(BanlaceEnum.Relation.MONEY.getState())
                .andUserIdEqualTo(userId)
                .andIsDeletedEqualTo((short) 0);
        List<SecondStoreBalance> secondStoreBalances =
        secondStoreBalanceMapper.selectByExample(secondStoreBalanceExample);
        if (secondStoreBalances.size()==0){
            SecondStoreBalance secondStoreBalance = new SecondStoreBalance();
            secondStoreBalance.setBalanceType(BanlaceEnum.Relation.MONEY.getState());
            secondStoreBalance.setUserId(userId);
            secondStoreBalance.setStoreId(storeId);
            secondStoreBalance.setSecondBalance(0);
            secondStoreBalance.setCreateTime(LocalDateTime.now());
            secondStoreBalance.setModifyTime(LocalDateTime.now());
            secondStoreBalance.setIsDeleted((short) 0);
            secondStoreBalanceMapper.insertSelective(secondStoreBalance);
            response.sendError(HttpStatus.FORBIDDEN.value(), "余额不足");
            return builder.body(ResponseUtils.getResponseBody(1));
        }
        if (balanceService.addStock(userId,storeId,BanlaceEnum.Relation.MONEY.getState(),withdrawalMoney)>1){
            /**
             * 取出提现利率
             */
            double rate = 0.0;//利率
            SecondBossExample secondBossExample = new SecondBossExample();
            secondBossExample.createCriteria().andIdEqualTo(1)
                    .andIsDeletedEqualTo((byte) 0);
            List<SecondBoss> secondBosses =
            secondBossMapper.selectByExample(secondBossExample);
            /**
             * 利率赋值
             */
            if (source.equals(WithdrawalEnum.WithdrawalSource.SON.getWithdrawalSource())){
                rate = secondBosses.get(0).getSonWithdrawalCommission();
            }else if (source.equals(WithdrawalEnum.WithdrawalSource.STORE.getWithdrawalSource())){
                rate = secondBosses.get(0).getStoreWithdrawalCommission();
            } else if (source.equals(WithdrawalEnum.WithdrawalSource.USER.getWithdrawalSource())){
                rate = secondBosses.get(0).getUserWithdrawalCommission();
            }else {
                return builder.body(ResponseUtils.getResponseBody("没有这个来源"));
            }
            Double realityMoneys = ((Double.valueOf(withdrawalMoney) / 10000));
//            Double realityMoneys = ((Double.valueOf(withdrawalMoney)*rate)/100);//                        利息进一位
            Integer realityMoneyx = (int) Math.ceil(realityMoneys);
            //                        提现实际金额
            Integer realityMoney = withdrawalMoney-(realityMoneyx*(int)(rate*100));
            if (source.equals(WithdrawalEnum.WithdrawalSource.USER.getWithdrawalSource())){
                SecondUserSonExample secondUserSonExample = new SecondUserSonExample();
                secondUserSonExample.createCriteria().andUserIdEqualTo(userId)
                        .andStoreIdEqualTo(storeId)
                        .andIsDeletedEqualTo((byte) 0);
                List<SecondUserSon> secondUserSons =
                        secondUserSonMapper.selectByExample(secondUserSonExample);
                sonBalanceService.add(secondUserSons.get(0).getSonId(),((realityMoneyx*(int)(rate*100))*30)/100);
            }
            SecondWithdrawal secondWithdrawal = new SecondWithdrawal();
            secondWithdrawal.setSource(source);
            secondWithdrawal.setWithdrawalMark(getC(null));
            secondWithdrawal.setPhone(phone);
            secondWithdrawal.setWithdrawalMoney(withdrawalMoney);
            secondWithdrawal.setRealityMoney(realityMoney);
            secondWithdrawal.setWithdrawalAccount(withdrawalAccount);
            secondWithdrawal.setWithdrawalName(withdrawalName);
            secondWithdrawal.setWithdrawalState(WithdrawalEnum.WithdrawalState.CHECK.getWithdrawalState());
            SecondWithdrawalMethod secondWithdrawalMethod =
            secondWithdrawalMethodMapper.selectByPrimaryKey(methodId);
            secondWithdrawal.setWithdrawalType(secondWithdrawalMethod.getWithdrawalWayName());
            secondWithdrawal.setMethodId(methodId);
            secondWithdrawal.setUserId(userId);
            secondWithdrawal.setStoreId(storeId);
            secondWithdrawal.setSonId(sonId);
            secondWithdrawal.setCreateDate(LocalDateTime.now());
            secondWithdrawal.setModifyDate(LocalDateTime.now());
            secondWithdrawal.setIsDeleted((byte) 0);
            secondWithdrawalMapper.insertSelective(secondWithdrawal);
            //店铺余额流水
            SecondStoreBalanceDetail secondStoreBalanceDetail = new SecondStoreBalanceDetail();
            secondStoreBalanceDetail.setUserId(userId);
            secondStoreBalanceDetail.setStoreId(storeId);
            secondStoreBalanceDetail.setAmount(-withdrawalMoney);
            secondStoreBalanceDetail.setDetailType(BanlaceEnum.Relation.MONEY.getState());
            secondStoreBalanceDetail.setIncomeExpenses(BanlaceEnum.incomeExpenses.PAY.getState());
            secondStoreBalanceDetail.setCreateTime(LocalDateTime.now());
            secondStoreBalanceDetail.setModifyTime(LocalDateTime.now());
            secondStoreBalanceDetail.setIsDeleted((short) 0);
            secondStoreBalanceDetailMapper.insertSelective(secondStoreBalanceDetail);
        } else {
            response.sendError(HttpStatus.FORBIDDEN.value(), "余额不足");
            return builder.body(ResponseUtils.getResponseBody(1));
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    @RequestMapping(path = "/selectWithdrawal", method = RequestMethod.POST)
    @ApiOperation(value = "查看提现列表", notes = "查看提现列表")
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "source", value = "发起提现来源,user,store,son", required = true, type = "String"),
    })
    public ResponseEntity<JSONObject> selectWithdrawal(@RequestParam(value = "source", required = false) String source,
                                                    HttpServletResponse response) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondWithdrawalExample secondWithdrawalExample = new SecondWithdrawalExample();
        secondWithdrawalExample.createCriteria().andSourceEqualTo(source)
                .andIsDeletedEqualTo((byte) 0);
        List<SecondWithdrawal> secondWithdrawal =
        secondWithdrawalMapper.selectByExample(secondWithdrawalExample);
        List<SecondWithdrawalList> secondWithdrawalLists = new ArrayList<>();
        secondWithdrawal.forEach(secondWithdrawal1 -> {
            SecondWithdrawalList secondWithdrawalList = new SecondWithdrawalList();
            secondWithdrawalList.setSecondWithdrawal(secondWithdrawal1.getId());
            if (source.equals(WithdrawalEnum.WithdrawalSource.SON.getWithdrawalSource())){
                SecondSonExample secondSonExample = new SecondSonExample();
                secondSonExample.createCriteria().andIdEqualTo(secondWithdrawal1.getSonId())
                        .andIsDeletedEqualTo((short) 0);
                List<SecondSon> secondSons =
                secondSonMapper.selectByExample(secondSonExample);
                secondWithdrawalList.setSonName(secondSons.get(0).getSonName());
            }
            if (source.equals(WithdrawalEnum.WithdrawalSource.USER.getWithdrawalSource())){
                SecondUserExample secondUserExample = new SecondUserExample();
                secondUserExample.createCriteria().andIdEqualTo(secondWithdrawal1.getUserId())
                        .andIdDeletedEqualTo((byte) 0);
                List<SecondUser> secondUsers =
                secondUserMapper.selectByExample(secondUserExample);
                secondWithdrawalList.setUserName(secondUsers.get(0).getNickName());
            }
            //店铺
            if (source.equals(WithdrawalEnum.WithdrawalSource.STORE.getWithdrawalSource())){
                SecondStoreExample secondStoreExample = new SecondStoreExample();
                secondStoreExample.createCriteria().andIdEqualTo(secondWithdrawal1.getStoreId())
                        .andIsDeletedEqualTo((short) 0)
                        .andSecondStatusEqualTo(Authentication.UserState.PASS.getState());
                List<SecondStore> secondStores =
                secondStoreMapper.selectByExample(secondStoreExample);
                secondWithdrawalList.setStoreName(secondStores.get(0).getStoreName());
            }
            secondWithdrawalList.setName(secondWithdrawal1.getWithdrawalName());
            secondWithdrawalList.setWithdrawalMoney(secondWithdrawal1.getWithdrawalMoney());
            secondWithdrawalList.setRealityMoney(secondWithdrawal1.getRealityMoney());
            secondWithdrawalList.setAccount(secondWithdrawal1.getWithdrawalAccount());
            secondWithdrawalList.setCreateTime(secondWithdrawal1.getCreateDate());
            secondWithdrawalList.setWithdrawalMethod(secondWithdrawal1.getWithdrawalType());
            secondWithdrawalLists.add(secondWithdrawalList);
        });
        return builder.body(ResponseUtils.getResponseBody(secondWithdrawalLists));
    }
    public static void main(String[] args) {
        Integer money = 10100;
        Double realityMoneys1 = ((Double.valueOf(money) / 10000));
//        Double realityMoneys = ((Double.valueOf(money)*20)/100);//                        利息进一位
        Integer realityMoneyx = (int) Math.ceil(realityMoneys1);
        System.out.println(realityMoneyx);
    }
}
