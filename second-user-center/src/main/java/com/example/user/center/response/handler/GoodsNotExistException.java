package com.example.user.center.response.handler;

@SuppressWarnings("serial")
public class GoodsNotExistException extends Exception {
    public GoodsNotExistException(String message) {
        super(message);
    }
}