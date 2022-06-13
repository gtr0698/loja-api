package com.example.api.service;

import com.example.api.dto.usuario.CreateUsuarioRequestDto;
import com.example.api.dto.usuario.UpdateUsuarioRequestDto;
import com.example.api.exception.RegraException;
import com.example.api.model.Usuario;
import com.example.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario salvar(CreateUsuarioRequestDto usuario){
        Usuario usuarioNovo = usuario.convertToModel();

        return usuarioRepository.save(usuarioNovo);
    }

    public Page<Usuario> listar(Pageable pageable){
        return usuarioRepository.findAll(pageable);
    }

    public Usuario buscar(Long usuarioId){
        Usuario usuario = verificaExistencia(usuarioId);

        return usuario;
    }

    public Usuario verificaExistencia(Long usuarioId){
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(usuarioId);

        if(usuarioExistente.isEmpty()){
            throw new RegraException("Usuario não localizado");
        }

        return usuarioExistente.get();
    }

    public Usuario atualizar(Long usuarioId, UpdateUsuarioRequestDto request){
        Usuario usuario = verificaExistencia(usuarioId);
        Usuario usuarioAtualizado = usuario.atualizaUsuario(request.getNome(), request.getCodUsuario(),
                request.getEmail(), request.getSenha());

        return usuarioAtualizado;
    }

    public void excluir(Long usuarioId){
        verificaExistencia(usuarioId);

        usuarioRepository.deleteById(usuarioId);
    }
}
