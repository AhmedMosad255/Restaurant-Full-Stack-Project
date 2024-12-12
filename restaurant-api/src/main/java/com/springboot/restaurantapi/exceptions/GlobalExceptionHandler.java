package com.springboot.restaurantapi.exceptions;

import com.springboot.restaurantapi.bundel.BundleTranslatorService;
import com.springboot.restaurantapi.response.ExceptionResponse;
import jakarta.transaction.SystemException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{
    @ExceptionHandler(SystemException.class)
    public ResponseEntity<ExceptionResponse> handleException(SystemException exception){
        return ResponseEntity.ok(new ExceptionResponse(BAD_REQUEST, BundleTranslatorService.getMessageInEnglishAndArabic(exception.getMessage())));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> handleException(IllegalArgumentException exception){
        return ResponseEntity.ok(new ExceptionResponse(BAD_REQUEST, BundleTranslatorService.getMessageInEnglishAndArabic(exception.getMessage())));
    }
}
