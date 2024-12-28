package com.magno.admin.catalogo.domain.validation;

import java.util.List;

public interface ValidationHandler {
    ValidationHandler append(ValidationError validationError);

    ValidationHandler append(ValidationHandler handler);

    ValidationHandler validate(Validation validation);

    List<ValidationError> getErrors();

    default boolean hasErrors(){
        return getErrors() != null && !getErrors().isEmpty();
    }

    interface Validation {
        void validate();
    }
}
