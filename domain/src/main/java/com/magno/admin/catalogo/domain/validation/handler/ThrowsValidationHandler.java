package com.magno.admin.catalogo.domain.validation.handler;

import com.magno.admin.catalogo.domain.exceptions.DomainException;
import com.magno.admin.catalogo.domain.validation.ValidationError;
import com.magno.admin.catalogo.domain.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {
    @Override
    public ValidationHandler append(final ValidationError validationError) {
        throw DomainException.with(List.of(validationError));
    }

    @Override
    public ValidationHandler append(final ValidationHandler handler) {
        throw DomainException.with(handler.getErrors());
    }

    @Override
    public ValidationHandler validate(Validation validation) {
        try {
            validation.validate();
        } catch (final Exception ex) {
            throw DomainException.with(new ValidationError(ex.getMessage()));
        }

        return this;
    }

    @Override
    public List<ValidationError> getErrors() {
        return List.of();
    }
}
