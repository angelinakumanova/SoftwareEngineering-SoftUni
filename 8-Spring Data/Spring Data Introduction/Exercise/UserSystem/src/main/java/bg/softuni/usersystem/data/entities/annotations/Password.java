package bg.softuni.usersystem.data.entities.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {
    int minLength() default 6;
    int maxLength() default 50;
    boolean containsDigit() default false;
    boolean containsLowerCase() default false;
    boolean containsUpperCase() default false;
    boolean containsSpecialSymbol() default false;
    String message() default "Invalid password format";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
