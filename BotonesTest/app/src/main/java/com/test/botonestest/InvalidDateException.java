package com.test.botonestest;

/**
 * Created by Usuario on 15/12/2017.
 */

public class InvalidDateException extends RuntimeException {

    public InvalidDateException(String str){
        super("Fecha "+str);
    }
}
