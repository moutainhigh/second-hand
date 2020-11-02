//package com.example.order.center.controller;
//
//import com.alibaba.fastjson.JSONObject;
//import com.example.order.center.dao.SecondWithdrawalMethodMapper;
//import com.example.order.center.model.SecondEvaluate;
//import com.example.order.center.model.SecondEvaluateFile;
//import com.example.order.center.model.SecondOrderDetail;
//import com.example.order.center.model.SecondWithdrawalMethod;
//import com.second.utils.response.handler.ResponseEntity;
//import com.second.utils.response.handler.ResponseUtils;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import org.apache.http.NameValuePair;
//import org.apache.http.message.BasicNameValuePair;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.configurationprocessor.json.JSONException;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//import java.net.URL;
//import java.net.URLConnection;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.CountDownLatch;
//
///**
// * @author shihao
// * @Title: ConcurrenceController
// * @ProjectName Second-order-center
// * @Description: 并发
// * @date Created in
// * @Version: $
// */
//@RestController
//@Api
//@RequestMapping("/Concurrence")
//@CrossOrigin
//public class ConcurrenceController {
////    public static void main(String[] args) {
////        int count=100;
////        final CountDownLatch cdl=new CountDownLatch(count);
////        for (int i = 0; i < count; i++) {
////            new Thread(new Runnable() {
////                @Override
////                public void run() {
////                    cdl.countDown();
////                    try {
////                        cdl.await();
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                    try {
////                        connect();
////                    } catch (Exception e) {
////                        e.printStackTrace();
////                    }
////                }
////            }).start();
////        }
////
////    }
////
////    public static void connect() throws Exception {
//////        final String urlStr="https://blog.52itstyle.com/";
////        final String urlStr="http://39.100.237.144:7002/product/SecondProduct/selectProduct?showType=product";
////        URL url=new URL(urlStr);
////        URLConnection urlConnection = url.openConnection();
////        urlConnection.setDoInput(true);
////        urlConnection.setDoOutput(true);
////        urlConnection.connect();
////        System.out.println(urlConnection.getInputStream());
////    }
//    //2
//
//    @Autowired
//    private SecondWithdrawalMethodMapper secondWithdrawalMethodMapper;
//    @Resource
//    private RedisTemplate<String, Object> redisTemplate;
//    /**
//     * 定义并发线程数量
//     */
//    public static final int THREAD_NUM = 100;
//
//    /**
//     * 开始时间
//     */
//    private static long startTime = 0L;
//
//    @PostConstruct
//    public void init() {
//        try {
//
//            startTime = System.currentTimeMillis();
//            System.out.println("CountDownLatch started at: " + startTime);
//
//            // 初始化计数器为1
//            CountDownLatch countDownLatch = new CountDownLatch(1);
//
//            for (int i = 0; i < THREAD_NUM; i ++) {
//                new Thread(new Run(countDownLatch)).start();
//            }
//
//            // 启动多个线程
//            countDownLatch.countDown();
//
//        } catch (Exception e) {
//            System.out.println("Exception: " + e);
//        }
//    }
//
//    /**
//     * 线程类
//     */
//    private class Run implements Runnable {
//        private final CountDownLatch startLatch;
//
//        public Run(CountDownLatch startLatch) {
//            this.startLatch = startLatch;
//        }
//
//        @Override
//        public void run() {
//            try {
//                // 线程等待
//                startLatch.await();
//
//                // 执行操作
//                /**
//                 这里调用你要测试的接口
//                 */
//                HttpClientUtil httpClientUtil = new HttpClientUtil();
//                List<NameValuePair> formParams = new ArrayList<>();
////                formParams.add(new BasicNameValuePair("name","thumbnailImg"));
////                formParams.add(new BasicNameValuePair("editType","center"));
//                formParams.add(new BasicNameValuePair("id","400"));
////                formParams.add(new BasicNameValuePair("height","400"));
//                httpClientUtil.doPost("http://localhost:7003/order/Concurrence/addEvaluate",formParams);
//                long endTime = System.currentTimeMillis();
//                System.out.println(Thread.currentThread().getName() + " ended at: " + endTime + ", cost: " + (endTime - startTime) + " ms.");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//
//    public static void main(String[] args) {
//        ConcurrenceController apiTest = new ConcurrenceController();
//        apiTest.init();
//    }
//
//    @ApiOperation(value = "高并发测试", notes = "高并发测试")
////    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
//    @RequestMapping(value = "/addEvaluate", method = RequestMethod.POST)
//    public synchronized ResponseEntity<JSONObject> addEvaluate()
//            throws JSONException {
//        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
////        SecondWithdrawalMethod secondWithdrawalMethod =
////        secondWithdrawalMethodMapper.selectByPrimaryKey(1);
////        redisTemplate.opsForValue().set("concurrence",100);
//        Object a =
//        redisTemplate.opsForValue().get("concurrence");
//        int b  = (int) a;
//        if (b>0){
//            b = b-1;
//            System.out.println("购买成功");
//            System.out.println(b);
//            redisTemplate.opsForValue().set("concurrence",b);
////            secondWithdrawalMethod.setWithdrawalCommission(secondWithdrawalMethod.getWithdrawalCommission()-1);
////            secondWithdrawalMethodMapper.updateByPrimaryKeySelective(secondWithdrawalMethod);
//        } else {
//            System.out.println("购买失败");
//        }
//        return builder.body(ResponseUtils.getResponseBody(0));
//    }
//}
