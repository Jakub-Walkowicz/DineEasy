package com.dineeasy.restaurant.domain.restaurant.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = OpenBeforeCloseValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface OpenBeforeClose {
    String message() default "Open time must be before the close time";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
