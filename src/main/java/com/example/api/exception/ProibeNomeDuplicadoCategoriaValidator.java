package com.example.api.exception;

import com.example.api.dto.categoria.CreateCategoriaRequestDto;
import com.example.api.dto.categoria.UpdateCategoriaRequestDto;
import com.example.api.model.Categoria;
import com.example.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.util.Optional;


@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {

        return CreateCategoriaRequestDto.class.isAssignableFrom(clazz)
                || UpdateCategoriaRequestDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CreateCategoriaRequestDto request = (CreateCategoriaRequestDto) target;

        Optional<Categoria> possivelCategoria = categoriaRepository
                .findByNome(request.getNome());

        if(possivelCategoria.isPresent()){
            errors.rejectValue("nome", null,
                    "Já existe uma Categoria com esse nome cadastrado "
            + request.getNome());
        }
    }
}
