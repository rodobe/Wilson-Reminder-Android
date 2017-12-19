package com.test.botonestest;

public class InUseCategoryException extends RuntimeException{
    public InUseCategoryException(String category){
        super(category+" ya existe");
    }
}
