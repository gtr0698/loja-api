package com.example.api.dto.produto;

import com.example.api.dto.categoria.CategoriaRequestDto;
import com.example.api.model.Categoria;
import com.example.api.model.Produto;
import com.example.api.validator.VerificaCodigoDuplicadoProduto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateProdutoRequestDto {

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nome;

    @NotNull
    private CategoriaRequestDto categoria;

    @NotNull
    private int quantidade;

    @NotNull
    @VerificaCodigoDuplicadoProduto
    private String codigo;

    private String descricao;

    private Boolean destaque;

    public CreateProdutoRequestDto(String nome, CategoriaRequestDto categoria, int quantidade, String codigo,
                                   String descricao) {
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.codigo = codigo;
        this.descricao = descricao;
        this.destaque = false;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaRequestDto getCategoria() {
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

    public Produto convertToModel(Categoria categoria){
        return new Produto(nome, categoria, quantidade, codigo,descricao);
    }

    public CreateProdutoRequestDto() {
        super();
    }

}
