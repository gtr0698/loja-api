package com.example.api.dto.categoria;

import com.example.api.validator.VerificaNomeDuplicadoCategoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateCategoriaRequestDto {

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 50)
    @VerificaNomeDuplicadoCategoria
    private String nome;

    private String descricao;

    public UpdateCategoriaRequestDto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public UpdateCategoriaRequestDto() {
        super();
    }
}
