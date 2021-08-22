package com.likhalikhi.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;




@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    Logger logger = Logger.getLogger(ResponseExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.warn("In handleHttpMessageNotReadable");
        ApiError error = new ApiError("Request Body is not supported", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);
    }

}
