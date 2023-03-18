package com.texhnolyze.farmacia.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException() {
        super("Resource not found on server!!");
    }

    public ClientNotFoundException(String s) {
        super(s);
    }
}
