package lt.boreisa.finalblog.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Constraint(validatedBy = {PhoneValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
    String message() default "{phone.error}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
