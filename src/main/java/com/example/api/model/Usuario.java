package com.example.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty
    private String nome;

    @NotBlank
    @NotEmpty
    private String codUsuario;

    @NotNull
    @Email
    private String email;

    @NotBlank
    @NotEmpty
    private String senha;

    public Usuario(String nome, String codUsuario, String email, String senha) {
        this.nome = nome;
        this.codUsuario = codUsuario;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario atualizaUsuario(String nome, String codUsuario, String email, String senha) {
        this.nome = nome;
        this.codUsuario = codUsuario;
        this.email = email;
        this.senha = senha;

        return this;
    }

    public Usuario() {
    }
}
