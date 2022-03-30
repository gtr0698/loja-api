package com.example.api.dto.categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateCategoriaRequestDto {

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
