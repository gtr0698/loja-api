package com.example.api.model;

import com.example.api.validator.VerificaCodigoDuplicadoProduto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Produto {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nome;

    @NotNull
    @ManyToOne
    private Categoria categoria;

    @NotNull
    private int quantidade;

    @NotNull
    private String codigo;

    private String descricao;

    public Produto(String nome, Categoria categoria, int quantidade, String codigo, String descricao) {
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

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto atualizaProduto(String nome, Categoria categoria, int quantidade, String codigo,
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
