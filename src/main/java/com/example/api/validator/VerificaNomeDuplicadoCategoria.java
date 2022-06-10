package com.example.api.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidadorDeNomeDuplicadoCategoria.class)
public @interface VerificaNomeDuplicadoCategoria {

    String message() default "Já existe uma categoria com esse nome cadastrado";

    Class[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
