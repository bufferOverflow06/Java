package com.example.ProductManagement.ErrorBean;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{

    private String msg;
    private HttpStatus httpStatus;

    public CustomException(HttpStatus httpStatus, String msg){
        this.msg = msg;
        this.httpStatus = httpStatus;
    }

    public CustomException(String msg){
        this.msg = msg;
    }

    public CustomException(){

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String toString() {
        return "CustomException [msg=" + msg + ", httpStatus=" + httpStatus + "]";
    }
}
