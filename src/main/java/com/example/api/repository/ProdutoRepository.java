package com.example.api.repository;

import com.example.api.dto.categoria.CategoriaResponseDto;
import com.example.api.dto.produto.ProdutoResponseDto;
import com.example.api.model.Categoria;
import com.example.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long> {

    Optional<Produto> findByCodigo(int codigo);
    List<Produto> findByCategoriaId(Long categoria);
    List<Produto> findByCategoriaNome(String categorias);
}
