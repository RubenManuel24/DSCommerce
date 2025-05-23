package com.rudev.dscommerce.DSCommerce.controllers.handler;

import com.rudev.dscommerce.DSCommerce.dto.CustomError;
import com.rudev.dscommerce.DSCommerce.service.exceptions.DataIntegrityException;
import com.rudev.dscommerce.DSCommerce.service.exceptions.ForbiddenException;
import com.rudev.dscommerce.DSCommerce.service.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    };

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<CustomError> dataException(DataIntegrityException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    };
    
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<CustomError> dataException(ForbiddenException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.FORBIDDEN;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    };

}
