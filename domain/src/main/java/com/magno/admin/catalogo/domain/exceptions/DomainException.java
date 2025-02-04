package com.magno.admin.catalogo.domain.exceptions;

import com.magno.admin.catalogo.domain.validation.ValidationError;

import java.util.List;

public class DomainException extends NoStacktraceException {

    private final List<ValidationError> errors;

    private DomainException(final String message, final List<ValidationError> errors) {
        super(message);
        this.errors = errors;
    }

    public static DomainException with(final ValidationError error) {
        return new DomainException(error.message(), List.of(error));
    }

    public static DomainException with(final List<ValidationError> errors) {
        return new DomainException("", errors);
    }

    public List<ValidationError> getErrors() {
        return errors;
    }
}
