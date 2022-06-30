package com.test.customer.error;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<Gender, Character> {

    public void initialize(Gender sex)
    {
        // used only if your annotation has attributes
    }

    public boolean isValid(Character gender, ConstraintValidatorContext constraintContext)
    {
        // Bean Validation specification recommends to consider null values as
        // being valid. If null is not a valid value for an element, it should
        // be annotated with @NotNull explicitly.
        if (gender == null)
        {
            return true;
        }
        if (gender.equals('F') || gender.equals('M'))
            return true;

        else
        {
            return false;
        }

    }
}
