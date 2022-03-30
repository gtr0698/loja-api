package com.example.api.dto.categoria;

import com.example.api.model.Categoria;

public class CategoriaResponseDto {

    private Long id;
    private String nome;
    private String descricao;

    public CategoriaResponseDto(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
