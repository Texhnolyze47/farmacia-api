package com.texhnolyze.farmacia.exceptions;

public class PrescriptionNotFoundException extends RuntimeException {
    public PrescriptionNotFoundException(String msg) {
        super(msg);
    }
}
