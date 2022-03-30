package com.example.api.repository;

import com.example.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long> {

    Produto findByCodigo(int codigo);
}
