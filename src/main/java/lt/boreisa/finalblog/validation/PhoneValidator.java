package lt.boreisa.finalblog.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import static lt.boreisa.finalblog.utils.StringUtil.areCharsDigits;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Override
    public void initialize(Phone constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        if (value.length() == 9 && value.startsWith("86")) {
            return areCharsDigits(value.substring(2));
        }
        if (value.length() == 12 && value.startsWith("+370")) {
            return areCharsDigits(value.substring(3));
        }
        if (value.length() == 11 && value.startsWith("+1")) {
            return areCharsDigits(value.substring(1));
        }
        if (value.length() == 11 && value.startsWith("+7")) {
            return areCharsDigits(value.substring(1));
        }
        return false;
    }
}
