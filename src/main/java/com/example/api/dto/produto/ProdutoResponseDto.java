package com.example.api.dto.produto;

import com.example.api.model.Categoria;
import com.example.api.model.Produto;

import java.util.List;

public class ProdutoResponseDto {

    private Long id;
    private String nome;
    private Categoria categoria;
    private int quantidade;
    private String codigo;
    private String descricao;
    private Boolean destaque;

    public ProdutoResponseDto(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.categoria = produto.getCategoria();
        this.quantidade = produto.getQuantidade();
        this.codigo = produto.getCodigo();
        this.descricao = produto.getDescricao();
        this.destaque = produto.getDestaque();
    }

    public Long getId() {
        return id;
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

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Boolean getDestaque() {
        return destaque;
    }

    public ProdutoResponseDto(){
        super();
    }
}
