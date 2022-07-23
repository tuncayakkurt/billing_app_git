package com.billing.installcustomerws.exceptions;

import com.billing.installcustomerws.enums.CustomHttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.status(CustomHttpStatus.METHOD_ARGUMENT_NOT_VALID.status()).body(errorMap);
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<?> alreadyExistsException(CustomerAlreadyExistsException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
        return ResponseEntity.status(CustomHttpStatus.CUSTOMER_ALREADY_EXISTS.status()).body(errorMessage);
    }
}
