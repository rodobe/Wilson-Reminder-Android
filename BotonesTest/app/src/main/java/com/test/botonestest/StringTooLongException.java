package com.test.botonestest;

import android.widget.Toast;

public class StringTooLongException extends RuntimeException{

    public StringTooLongException(String str, int lim){
        super(str+" no puede exceder los "+lim+" caracteres");
    }
}
