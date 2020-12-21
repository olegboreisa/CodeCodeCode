package lt.boreisa.finalblog.Validation;

import lt.boreisa.finalblog.Model.User;

import javax.validation.Constraint;
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
