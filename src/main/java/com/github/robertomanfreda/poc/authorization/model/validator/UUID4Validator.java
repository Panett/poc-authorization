package com.github.robertomanfreda.poc.authorization.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UUID4Validator implements ConstraintValidator<UUID4ValidatorConstraint, String> {

    @Override
    public void initialize(UUID4ValidatorConstraint uuid4) {
    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
        return contactField!=null && contactField.matches("(?i)^[0-9A-F]{8}-[0-9A-F]{4}-[4][0-9A-F]{3}-[89AB][0-9A-F]{3}-[0-9A-F]{12}$");
    }
}