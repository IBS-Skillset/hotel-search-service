package com.hotel.api.search.handler;

import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(StatusRuntimeException.class)
    public ResponseEntity<String> handleGRPCUnauthenticateException(StatusRuntimeException exception){
        log.error(exception.toString());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleGenericException(Throwable exception){
        log.error(exception.toString());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
    }
}
