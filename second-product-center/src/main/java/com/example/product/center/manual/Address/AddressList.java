package com.example.product.center.manual.Address;

import java.util.List;

/**
 * @author shihao
 * @Title: AddressList
 * @ProjectName Second-order-center
 * @Description: 腾讯地址返回
 * @date Created in
 * @Version: $
 */
public class AddressList {
    private Integer status;
    private String message;
    private List<AddressDetails> result;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AddressDetails> getResult() {
        return result;
    }

    public void setResult(List<AddressDetails> result) {
        this.result = result;
    }
}
