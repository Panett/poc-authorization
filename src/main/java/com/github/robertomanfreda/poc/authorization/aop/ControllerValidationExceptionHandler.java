package com.github.robertomanfreda.poc.authorization.aop;

import com.github.robertomanfreda.poc.authorization.model.response.LoginResponse;
import com.github.robertomanfreda.poc.authorization.model.response.ValidationErrorResponse;
import com.github.robertomanfreda.poc.authorization.model.response.ValidationFieldErrors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

@ControllerAdvice
public class ControllerValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        BindingResult bindingResult = exception.getBindingResult();
        ValidationErrorResponse validationErrorResponse = ValidationErrorResponse.builder()
                .validationErrorList(new ArrayList<>())
                .build();

        for (ObjectError error : bindingResult.getAllErrors()) {
            String field = ((FieldError) error).getField();
            Optional<ValidationFieldErrors> fieldOptional = validationErrorResponse.getValidationErrorList().stream().filter(validationFieldErrors -> validationFieldErrors.getField().equals(field)).findFirst();
            if(fieldOptional.isPresent()) {
                fieldOptional.get().getErrors().add(error.getDefaultMessage());
            } else {
                ValidationFieldErrors validationFieldErrors = ValidationFieldErrors.builder().field(field).errors(new ArrayList<>()).build();
                validationFieldErrors.getErrors().add(error.getDefaultMessage());
                validationErrorResponse.getValidationErrorList().add(validationFieldErrors);
            }
        }

        return new ResponseEntity<>(validationErrorResponse, HttpStatus.BAD_REQUEST);
    }
}