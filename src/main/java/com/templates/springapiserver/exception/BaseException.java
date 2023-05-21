package com.templates.springapiserver.exception;

import com.templates.springapiserver.constant.BaseStatus;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private Integer status;
    private String code;
    private String message;

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseException(Integer status, String code, String message) {
        super(message);
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public BaseException(Integer status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
        this.message = message;
    }

    public static BaseException of(BaseStatus baseStatus) {
        return new BaseException(
                baseStatus.getStatus(), baseStatus.getCode(), baseStatus.getMessage());
    }

    public static BaseException of(BaseStatus baseStatus, String message) {
        return new BaseException(baseStatus.getStatus(), baseStatus.getCode(), message);
    }
}
