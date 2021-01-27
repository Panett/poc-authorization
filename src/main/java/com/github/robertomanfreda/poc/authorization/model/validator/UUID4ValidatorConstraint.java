package com.github.robertomanfreda.poc.authorization.model.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UUID4Validator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UUID4ValidatorConstraint {
    String message() default "It's not a valid UUID4 format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}