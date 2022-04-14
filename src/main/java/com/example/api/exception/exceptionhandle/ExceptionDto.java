package com.example.api.exception.exceptionhandle;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionDto {

    private Integer status;
    private String titulo;
    private List<Campo> campos;

    public static class Campo{

        private String nome;
        private String mensagem;

        public Campo(String nome, String mensagem) {
            this.nome = nome;
            this.mensagem = mensagem;
        }

        public String getNome() {
            return nome;
        }

        public String getMensagem() {
            return mensagem;
        }
    }

    public Integer getStatus() {
        return status;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Campo> getCampos() {
        return campos;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCampos(List<Campo> campos) {
        this.campos = campos;
    }
}
