package com.alok.society.employeeRegistration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * Created by Alok
 * This is common place to handle the exception
 */
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({InvalidMethodArgumentException.class})
    public ResponseEntity<String> methodNotValid(InvalidMethodArgumentException e){
        return new ResponseEntity<String >("Invalid Input !!", HttpStatus.BAD_REQUEST);
    }
}
