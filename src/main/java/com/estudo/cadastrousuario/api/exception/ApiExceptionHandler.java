package com.estudo.cadastrousuario.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<Object> handlerRequestException(BaseException exception) {

        ApiException payloadDetails = new ApiException(exception.getMessage(), exception.getCause(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(payloadDetails, HttpStatus.BAD_REQUEST);
    }
}
