package com.example.api.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidadorDeCodigoDuplicadoProduto.class)
public @interface VerificaCodigoDuplicadoProduto {

    String message() default "Codigo já cadastrado no sistema!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] playload() default {};
}
