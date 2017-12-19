package com.test.botonestest;

public class NullFieldException extends RuntimeException {

    public NullFieldException(String field) {
        super(field+" es un campo obligatorio");
    }
}
