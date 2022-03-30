package com.example.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Produto {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Categoria categoria;

    private int quantidade;

    private int codigo;

    private String descricao;

    public Produto(String nome, Categoria categoria, int quantidade, int codigo, String descricao) {
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.codigo = codigo;
        this.descricao = descricao;
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

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto atualizaProduto(String nome, Categoria categoria, int quantidade, int codigo,
                                   String descricao){
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.codigo = codigo;
        this.descricao = descricao;

        return this;
    }

    public Produto() {
        super();
    }
}
