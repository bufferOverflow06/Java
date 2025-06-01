package com.example.ProductManagement.ErrorBean;

import org.springframework.http.HttpStatus;

public class ErrorResponse{
    private String msg;
    private HttpStatus httpStatus;
    Long timemilli;

    public ErrorResponse() {
    }

    public ErrorResponse(String msg, HttpStatus httpStatus, Long timemilli) {
        this.msg = msg;
        this.httpStatus = httpStatus;
        this.timemilli = timemilli;
    }

    public ErrorResponse(String msg, HttpStatus httpStatus){
        this.msg = msg;
        this.httpStatus = httpStatus;
    }

    @Override
    public String toString() {
        return "ErrorResponse [msg=" + msg + ", httpStatus=" + httpStatus + ", timemilli=" + timemilli + "]";
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

    public Long getTimemilli() {
        return timemilli;
    }

    public void setTimemilli(Long timemilli) {
        this.timemilli = timemilli;
    }
}
