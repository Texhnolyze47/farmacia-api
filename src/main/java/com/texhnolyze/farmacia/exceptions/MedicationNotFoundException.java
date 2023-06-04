package com.texhnolyze.farmacia.exceptions;

public class MedicationNotFoundException extends RuntimeException {
    public MedicationNotFoundException(String msg) {
        super(msg);
    }
}
