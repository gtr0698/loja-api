package com.example.api.model;

import com.example.api.validator.VerificaNomeDuplicadoCategoria;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nome;

    private String descricao;

    public Categoria(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
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

    public Categoria atualizaCategoria(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;

        return this;
    }

    public Categoria() {
        super();
    }

}
