package lt.boreisa.finalblog.validation;

import lt.boreisa.finalblog.model.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation){
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        User user = (User) value;
        return user.getPassword().equals(user.getMatchPassword());
    }
}
