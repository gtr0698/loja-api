package com.example.api.service;

import com.example.api.dto.produto.CreateProdutoRequestDto;
import com.example.api.dto.produto.UpdateProdutoRequestDto;
import com.example.api.exception.RegraException;
import com.example.api.model.Produto;
import com.example.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(CreateProdutoRequestDto produto){
        Produto produtoExistente = produtoRepository.findByCodigo(produto.getCodigo());

        if(produtoExistente != null && produtoExistente.equals(produto)){
            throw new RegraException("O produto já está cadastrado no sistema");
        }

        Produto produtoNovo = produto.convertToModel();

        return produtoRepository.save(produtoNovo);
    }

    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    public Produto buscar(Long produtoId){
        Produto produto = verificaExistencia(produtoId);

        return produto;
    }

    public Produto atualizar(Long produtoId, UpdateProdutoRequestDto produtoRequest){
        Produto produto = verificaExistencia(produtoId);
        Produto produtoAtualizado = produto.atualizaProduto(produtoRequest.getNome(),
                produtoRequest.getCategoria(), produtoRequest.getCodigo(), produtoRequest.getQuantidade(),
                produtoRequest.getDescricao());

        return produtoRepository.save(produtoAtualizado);
    }

    public void excluir(Long produtoId){

        verificaExistencia(produtoId);

        produtoRepository.deleteById(produtoId);
    }

    public Produto verificaExistencia(Long produtoId){
        Optional<Produto> produto = produtoRepository.findById(produtoId);

        if(produto.isEmpty()){
            throw new RegraException("Produto não encontrado");
        }

        return produto.get();
    }
}
