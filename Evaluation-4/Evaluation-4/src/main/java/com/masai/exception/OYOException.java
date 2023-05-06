package com.masai.exception;

public class OYOException extends RuntimeException {

    OYOException(){

    }

    public OYOException(String str){
        super(str);
    }
}
