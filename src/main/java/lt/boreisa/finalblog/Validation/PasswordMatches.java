package lt.boreisa.finalblog.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface PasswordMatches {
        String message() default "Password does not match!";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
}
