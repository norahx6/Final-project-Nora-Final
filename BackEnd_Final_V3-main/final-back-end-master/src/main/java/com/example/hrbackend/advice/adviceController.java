package com.example.hrbackend.advice;

import com.example.hrbackend.dto.ApiResponse;
import com.example.hrbackend.exception.ApiException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class adviceController {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
//        String message=methodArgumentNotValidException.getFieldError().getDefaultMessage();
        String message = methodArgumentNotValidException.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message, 400));
    }

    @ExceptionHandler(value = HttpClientErrorException.NotFound.class)
    public ResponseEntity httpClientErrorException(HttpClientErrorException httpClientErrorException) {
        String message = httpClientErrorException.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message, 400));
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity dataIntegrityViolation(DataIntegrityViolationException dataIntegrityViolationException) {
        String message = dataIntegrityViolationException.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message, 400));

    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity constraintViolation(ConstraintViolationException constraintViolationException) {
        String message = constraintViolationException.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message, 400));
    }

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity apiException(ApiException apiException) {
        String message = apiException.getMessage();
        return ResponseEntity.status(500).body(new ApiResponse(message, 500));

    }
}