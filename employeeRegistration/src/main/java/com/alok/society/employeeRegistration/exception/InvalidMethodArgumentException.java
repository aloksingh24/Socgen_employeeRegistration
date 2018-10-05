package com.alok.society.employeeRegistration.exception;

public class InvalidMethodArgumentException extends Exception {
    private String msg;
    public InvalidMethodArgumentException(String msg){
        this.msg = msg;
    }
}
