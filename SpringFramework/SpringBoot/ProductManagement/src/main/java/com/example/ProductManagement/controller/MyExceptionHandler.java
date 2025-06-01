package com.example.ProductManagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.ProductManagement.ErrorBean.CustomException;
import com.example.ProductManagement.ErrorBean.ErrorResponse;

@RestControllerAdvice // handle from here first if it is not there go to parent class response
public class MyExceptionHandler{

    // important part
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getMsg(), e.getHttpStatus());
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

    public ResponseEntity<ErrorResponse> badCredentialExceptionhandling(BadCredentialsException e){

        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
