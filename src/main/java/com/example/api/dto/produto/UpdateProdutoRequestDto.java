package com.example.api.dto.produto;

import com.example.api.model.Categoria;

public class UpdateProdutoRequestDto {

    private String nome;

    private Categoria categoria;

    private int quantidade;

    private int codigo;

    private String descricao;

    public UpdateProdutoRequestDto(String nome, Categoria categoria, int quantidade, int codigo,
                                   String descricao) {
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public UpdateProdutoRequestDto() {
        super();
    }
}
