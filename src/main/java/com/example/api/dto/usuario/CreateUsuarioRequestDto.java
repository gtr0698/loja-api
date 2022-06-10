package com.example.api.dto.usuario;

import com.example.api.model.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateUsuarioRequestDto {

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

    public CreateUsuarioRequestDto(String nome, String codUsuario, String email, String senha) {
        this.nome = nome;
        this.codUsuario = codUsuario;
        this.email = email;
        this.senha = senha;
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

    public Usuario convertToModel(){
        return new Usuario(nome, codUsuario, email, senha);
    }

    public CreateUsuarioRequestDto() {
    }
}
