package com.example.payment.center.config;

import com.github.wxpay.sdk.WXPayConfig;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class MiniProgramConfig implements WXPayConfig {

    private byte[] certData;
    private String appId = "wx2641aaa105c07dd4";
    private String mchId = "1574620741";
    private String payKey = "tjsichuang0827abcdef199509abcdef";
    private String path = "payment/cert/apiclient_cert.p12";
//    @Bean
    @Override
    public String getAppID() {

        return getAppId();
    }

    @Override
    public String getMchID() {
        // TODO Auto-generated method stub
        return getMchId();
    }

    @Override
    public String getKey() {
        // TODO Auto-generated method stub
        return getPayKey();
    }

    @Override
    public InputStream getCertStream() {
        // TODO Auto-generated method stub
        InputStream certStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(getPath());
        try {
            this.certData = IOUtils.toByteArray(certStream);
            certStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(this.certData);
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        // TODO Auto-generated method stub
        return 0;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getPayKey() {
        return payKey;
    }

    public void setPayKey(String payKey) {
        this.payKey = payKey;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


}
