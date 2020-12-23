package lt.boreisa.finalblog.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface PasswordMatches {
        String message() default "Password does not match!";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
}
