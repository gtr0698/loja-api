package com.example.api.service;

import com.example.api.dto.produto.CreateProdutoRequestDto;
import com.example.api.dto.produto.UpdateProdutoRequestDto;
import com.example.api.exception.RegraException;
import com.example.api.model.Categoria;
import com.example.api.model.Produto;
import com.example.api.repository.CategoriaRepository;
import com.example.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(CreateProdutoRequestDto produtoDto){
        Categoria categoria = categoriaRepository.findById(produtoDto.getCategoria().getId()).orElseThrow(() ->
                new RegraException("Categoria não encontrada com o id = " + produtoDto.getCategoria().getId(), "Categoria")
        );

        Produto produtoNovo = produtoDto.convertToModel(categoria);

        return produtoRepository.save(produtoNovo);
    }

    public Page<Produto> listar(Pageable pageable){
        return produtoRepository.findAll(pageable);
    }

    public Produto buscar(Long produtoId){
        Produto produto = verificaExistencia(produtoId);

        return produto;
    }

    public Produto atualizar(Long produtoId, UpdateProdutoRequestDto produtoRequest){
        Produto produto = verificaExistencia(produtoId);
        Produto produtoAtualizado = produto.atualizaProduto(produtoRequest.getNome(),
                produtoRequest.getCategoria(),produtoRequest.getQuantidade(), produtoRequest.getCodigo(),
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


    public List<Produto> listaPorCategoria(Long categoria) {
        List<Produto> listaCategorias = produtoRepository.findByCategoriaId(categoria);

        return listaCategorias;
    }

    public List<Produto> listaNomeCategoria(String categorias) {
        List<Produto> listaCategoriaNome = produtoRepository.findByCategoriaNome(categorias);

        return listaCategoriaNome;
    }
}
