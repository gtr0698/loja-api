package com.example.api.dto.categoria;

import com.example.api.model.Categoria;

public class CreateCategoriaRequestDto {

    private String nome;
    private String descricao;

    public CreateCategoriaRequestDto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Categoria convertToModel(){
        return new Categoria(nome, descricao);
    }

    public CreateCategoriaRequestDto(){
        super();
    }
}
