package com.github.robertomanfreda.poc.authorization.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ValidationErrorResponse {
    List<ValidationFieldErrors> validationErrorList;
}

