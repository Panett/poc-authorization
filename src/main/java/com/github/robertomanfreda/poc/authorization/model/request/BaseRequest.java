package com.github.robertomanfreda.poc.authorization.model.request;

import com.github.robertomanfreda.poc.authorization.model.validator.UUID4ValidatorConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BaseRequest {

    @NotEmpty
    @UUID4ValidatorConstraint
    private String requestID;
}
