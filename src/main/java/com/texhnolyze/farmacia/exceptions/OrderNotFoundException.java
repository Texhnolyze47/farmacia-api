package com.texhnolyze.farmacia.exceptions;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(String msg) {
        super(msg);
    }
}
