package com.ktchat.chat_app.validation;

import javax.xml.validation.Validator;

import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;

public class ObjectsValidator<T> {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = (Validator) factory.getValidator();

    private void validate(T objectToValidate) {
        // Set<ConstraintViolation<T>> violations =
        // validator.validate(objectToValidate);
    }

}
