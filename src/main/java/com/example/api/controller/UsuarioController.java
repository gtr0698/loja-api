package com.example.api.controller;

import com.example.api.dto.usuario.CreateUsuarioRequestDto;
import com.example.api.dto.usuario.UpdateUsuarioRequestDto;
import com.example.api.dto.usuario.UsuarioResponseDto;
import com.example.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto>adicionar(@Valid @RequestBody CreateUsuarioRequestDto usuario){
        UsuarioResponseDto novoUsuario = new UsuarioResponseDto(usuarioService.salvar(usuario));

        return ResponseEntity.ok(novoUsuario);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>>listar(Pageable pageable){
        List<UsuarioResponseDto> usuarios = usuarioService.listar(pageable).stream()
                .map(UsuarioResponseDto::new).collect(Collectors.toList());

        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioResponseDto>buscar(@PathVariable Long usuarioId){
        UsuarioResponseDto usuarioLocalizado = new UsuarioResponseDto(usuarioService.buscar(usuarioId));

        return ResponseEntity.ok(usuarioLocalizado);
    }

    @PutMapping("/{usuarioId}")
    public ResponseEntity<UsuarioResponseDto>atualizar(@Valid @PathVariable Long usuarioId,
                                                       @RequestBody UpdateUsuarioRequestDto request){
        UsuarioResponseDto atualizarUsuario = new UsuarioResponseDto(usuarioService.atualizar(usuarioId,
                request));

        return ResponseEntity.ok(atualizarUsuario);
    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<?>remover(@PathVariable Long usuarioId){
        usuarioService.excluir(usuarioId);

        return ResponseEntity.noContent().build();
    }

}
