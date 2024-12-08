package com.springboot.restaurantapi.exceptions;

import com.springboot.restaurantapi.bundel.BundleTranslatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final BundleTranslatorService bundleTranslatorService;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorResponse>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ValidationErrorResponse> errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(this::mapToValidationErrorResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(errors, BAD_REQUEST);
    }

    private ValidationErrorResponse mapToValidationErrorResponse(ObjectError error) {
        // Use BundleTranslatorService to fetch the localized message
        String localizedMessage = bundleTranslatorService.getMessage(error.getDefaultMessage());
        return new ValidationErrorResponse(error.getObjectName(), localizedMessage);
    }
}
