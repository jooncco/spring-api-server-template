package com.templates.springapiserverasync.exception;


import com.templates.springapiserverasync.constant.BaseStatus;

public class BaseException extends RuntimeException {

    private Integer status;
    private String code;
    private String message;

    public BaseException(BaseStatus baseStatus) {
        super(baseStatus.getMessage());
        status = baseStatus.getStatus();
        code = baseStatus.getCode();
        message = baseStatus.getMessage();
    }

    public BaseException(Integer status, String code, String message) {
        super(message);
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
