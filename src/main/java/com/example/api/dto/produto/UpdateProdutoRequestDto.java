package com.example.api.dto.produto;

import com.example.api.model.Categoria;
import com.example.api.validator.VerificaCodigoDuplicadoProduto;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateProdutoRequestDto {

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
    @VerificaCodigoDuplicadoProduto
    private String codigo;

    private String descricao;

    private Boolean destaque;

    public UpdateProdutoRequestDto(String nome, Categoria categoria, int quantidade, String codigo,
                                   String descricao, Boolean destaque) {
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.codigo = codigo;
        this.descricao = descricao;
        this.destaque = destaque;
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

    public UpdateProdutoRequestDto() {
        super();
    }
}
