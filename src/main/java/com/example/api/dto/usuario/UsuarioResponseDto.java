package com.example.api.dto.usuario;

import com.example.api.model.Usuario;

public class UsuarioResponseDto {

    private Long id;
    private String nome;
    private String codUsuario;
    private String email;
    private String senha;

    public UsuarioResponseDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.codUsuario = usuario.getCodUsuario();
        this.email = usuario.getEmail();
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

    public UsuarioResponseDto() {
    }
}
