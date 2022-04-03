package com.example.api.exception;

import com.example.api.dto.produto.CreateProdutoRequestDto;
import com.example.api.model.Produto;
import com.example.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeCodigoDuplicadoProdutoValidator implements Validator {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CreateProdutoRequestDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if(errors.hasErrors()){
            return;
        }

        CreateProdutoRequestDto request = (CreateProdutoRequestDto) target;

        Optional<Produto> possivelProduto = produtoRepository
                .findByCodigo(request.getCodigo());

        if(possivelProduto.isPresent()){
            errors.rejectValue("codigo", null,
                    "Já existe um produto com este Codigo cadastrado");
        }

    }
}
