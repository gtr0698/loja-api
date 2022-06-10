package com.example.api.validator;

import com.example.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidadorDeNomeDuplicadoCategoria implements ConstraintValidator<VerificaNomeDuplicadoCategoria, String> {

    @Autowired
    private CategoriaRepository categoriaRepository;


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){

        return this.categoriaRepository.findByNome(value).isEmpty();
    }
}
