package com.example.api.controller;

import com.example.api.dto.categoria.CategoriaResponseDto;
import com.example.api.dto.produto.CreateProdutoRequestDto;
import com.example.api.dto.produto.ProdutoResponseDto;
import com.example.api.dto.produto.UpdateProdutoRequestDto;
import com.example.api.exception.ProibeCodigoDuplicadoProdutoValidator;
import com.example.api.model.Categoria;
import com.example.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProibeCodigoDuplicadoProdutoValidator proibeCodigoDuplicadoProdutoValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(proibeCodigoDuplicadoProdutoValidator);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDto>>listar(){
        List<ProdutoResponseDto> produtos = produtoService.listar().stream()
                .map(produto -> new ProdutoResponseDto(produto)).collect(Collectors.toList());

        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{produtoId}")
    public ResponseEntity<ProdutoResponseDto>buscar(@PathVariable Long produtoId){
        ProdutoResponseDto produtoLocalizado = new ProdutoResponseDto(produtoService.buscar(produtoId));

        return ResponseEntity.ok(produtoLocalizado);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDto>adicionar(@Valid @RequestBody CreateProdutoRequestDto produto){
        ProdutoResponseDto produtoSalvo = new ProdutoResponseDto(produtoService.salvar(produto));

        return ResponseEntity.ok(produtoSalvo);
    }

    @PutMapping("/{produtoId}")
    public ResponseEntity<ProdutoResponseDto>atualizar(@Valid @PathVariable Long produtoId,
                                                       @RequestBody UpdateProdutoRequestDto produto){
        ProdutoResponseDto produtoSalvo = new ProdutoResponseDto(produtoService.atualizar(produtoId,
                produto));

        return ResponseEntity.ok(produtoSalvo);
    }

    @DeleteMapping("/{produtoId}")
    public ResponseEntity<?>remover(@PathVariable Long produtoId){
        produtoService.excluir(produtoId);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<ProdutoResponseDto>>listarProdutoCategoria(
            @PathVariable Long categoriaId){

        List<ProdutoResponseDto> listaProdutos = produtoService.listaPorCategoria(categoriaId)
                .stream().map(produto -> new ProdutoResponseDto(produto)).collect(Collectors.toList());

        return ResponseEntity.ok(listaProdutos);
    }

    /*
    @GetMapping("/categoria/{categoriaNome}")
    public ResponseEntity<List<ProdutoResponseDto>>ListaProdutoNomeCategoria(
            @PathVariable String categoriaNome){

        List<ProdutoResponseDto> listaProdutoNome = produtoService.listaNomeCategoria(categoriaNome)
                .stream().map(produto -> new ProdutoResponseDto(produto)).collect(Collectors.toList());

        return ResponseEntity.ok(listaProdutoNome);
    }
    */
}
