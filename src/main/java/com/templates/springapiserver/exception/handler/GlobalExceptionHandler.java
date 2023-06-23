package com.templates.springapiserver.exception.handler;

import com.templates.springapiserver.constant.BaseStatus;
import com.templates.springapiserver.dto.ErrorResponseBody;
import com.templates.springapiserver.exception.BaseException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
        MethodArgumentNotValidException.class,
        MissingServletRequestParameterException.class,
        HttpMessageNotReadableException.class
    })
    protected ResponseEntity<ErrorResponseBody> badRequestHandler(
            Exception ex, HttpServletRequest request) {
        return ResponseEntity.badRequest()
                .body(
                        ErrorResponseBody.builder()
                                .error(BaseStatus.BAD_REQUEST.getCode())
                                .message(ex.getMessage())
                                .uri(request.getRequestURI())
                                .build());
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    protected ResponseEntity<ErrorResponseBody> notFoundErrorHandler() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(BaseException.class)
    protected ResponseEntity<ErrorResponseBody> baseExceptionHandler(
            BaseException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.valueOf(ex.getStatus()))
                .body(
                        ErrorResponseBody.builder()
                                .error(ex.getCode())
                                .message(ex.getMessage())
                                .uri(request.getRequestURI())
                                .build());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponseBody> defaultExceptionHandler(
            Exception ex, HttpServletRequest request) {
        return ResponseEntity.internalServerError()
                .body(
                        ErrorResponseBody.builder()
                                .error(BaseStatus.UNKNOWN_ERROR.getCode())
                                .message(ex.getMessage())
                                .uri(request.getRequestURI())
                                .build());
    }
}
