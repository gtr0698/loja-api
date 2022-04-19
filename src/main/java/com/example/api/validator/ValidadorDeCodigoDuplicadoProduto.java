package com.example.api.validator;

import com.example.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidadorDeCodigoDuplicadoProduto implements ConstraintValidator<VerificaCodigoDuplicadoProduto, String>  {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){

        return this.produtoRepository.findByCodigo(value).isPresent();
    }

}
