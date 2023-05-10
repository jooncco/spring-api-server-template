package com.templates.springapiserverasync.exception.handler;

import com.templates.springapiserverasync.dto.ErrorResponse;
import com.templates.springapiserverasync.exception.BaseException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
RestController 에서 발생하는 Exception 을 중앙 제어한다.
Handler 에 등록한 Exception 발생시 메서드가 호출된다.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
        MethodArgumentNotValidException.class,
        MissingServletRequestParameterException.class,
        HttpMessageNotReadableException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse baseRequest(Exception ex, HttpServletRequest request) {
        String uri = null;
        if (ex instanceof MethodArgumentNotValidException) {
            uri = "PARAM_ME : ".concat(request.getRequestURI());
        }

        return ErrorResponse.builder()
                .error(ex.getClass().getName())
                .msg(ex.getMessage())
                .uri(uri)
                .build();
    }

    // TODO: 500 error handler
    // Failure in @ExceptionHandler
    // com.templates.springapiserverasync.exception.handler.GlobalExceptionHandler#internalServerError(Exception, HttpServletRequest

    @ExceptionHandler({Exception.class, BaseException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ErrorResponse internalServerError(Exception ex, HttpServletRequest request) {
        return ErrorResponse.builder()
                .error(ex.getClass().getName())
                .msg(ex.getMessage())
                .uri(request.getRequestURI())
                .build();
    }
}
