package com.texhnolyze.farmacia.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super("Resource not found on server!!");
    }

    public ProductNotFoundException(String s) {
        super(s);
    }
}
