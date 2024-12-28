package com.magno.admin.catalogo.domain.category;

import com.magno.admin.catalogo.domain.validation.ValidationError;
import com.magno.admin.catalogo.domain.validation.ValidationHandler;
import com.magno.admin.catalogo.domain.validation.Validator;

public class CategoryValidator extends Validator {

    private Category category;

    public static final int NAME_MAX_LENGTH = 255;
    public static final int NAME_MIN_LENGTH = 3;

    public CategoryValidator(final Category category, final ValidationHandler handler) {
        super(handler);
        this.category = category;
    }

    @Override
    public void validate() {
        checkNameConstraints();
    }

    private void checkNameConstraints() {
        final var name = this.category.getName();

        if (name == null) {
            this.validationHandler().append(new ValidationError("'name' should not be null"));
            return;
        }

        if (name.isBlank()) {
            this.validationHandler().append(new ValidationError("'name' should not be empty"));
            return;
        }

        final int length = name.trim().length();
        if (length > NAME_MAX_LENGTH || length < NAME_MIN_LENGTH) {
            this.validationHandler().append(new ValidationError("'name' must be between 2 and 255 characters"));
        }
    }
}
