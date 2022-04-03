package com.example.api.controller;

import com.example.api.dto.categoria.CategoriaResponseDto;
import com.example.api.dto.categoria.CreateCategoriaRequestDto;
import com.example.api.dto.categoria.UpdateCategoriaRequestDto;
import com.example.api.exception.ProibeNomeDuplicadoCategoriaValidator;
import com.example.api.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoriaValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(proibeNomeDuplicadoCategoriaValidator);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDto>>listar(){
        List<CategoriaResponseDto> categorias = categoriaService.listar().stream()
                .map(categoria -> new CategoriaResponseDto(categoria)).collect(Collectors.toList());

        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{categoriaId}")
    public ResponseEntity<CategoriaResponseDto> buscar(@PathVariable Long categoriaId){
        CategoriaResponseDto categoriaLocalizada = new CategoriaResponseDto(categoriaService.buscar(categoriaId));

        return ResponseEntity.ok(categoriaLocalizada);
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDto>adicionar(@Valid @RequestBody CreateCategoriaRequestDto categoria){
        CategoriaResponseDto categoriaSalva = new CategoriaResponseDto(categoriaService.salvar(categoria));

        return ResponseEntity.ok(categoriaSalva);
    }

    @PutMapping("/{categoriaId}")
    public ResponseEntity<CategoriaResponseDto>atualizar(@Valid @PathVariable Long categoriaId,
                                                         @RequestBody UpdateCategoriaRequestDto categoria){
        CategoriaResponseDto categoriaSalva = new CategoriaResponseDto(categoriaService.atualizar(categoriaId,
                categoria));

        return ResponseEntity.ok(categoriaSalva);
    }

    @DeleteMapping("/{categoriaId}")
    public ResponseEntity<?> remover(@PathVariable Long categoriaId){
        categoriaService.excluir(categoriaId);

        return ResponseEntity.noContent().build();
    }
}
