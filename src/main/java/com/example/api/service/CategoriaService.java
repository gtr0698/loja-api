package com.example.api.service;

import com.example.api.dto.categoria.CreateCategoriaRequestDto;
import com.example.api.dto.categoria.UpdateCategoriaRequestDto;
import com.example.api.exception.RegraException;
import com.example.api.model.Categoria;
import com.example.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;


    public Categoria salvar(CreateCategoriaRequestDto categoria){
        /*Categoria categoriaExistente = categoriaRepository.findByNome(categoria.getNome());

        if(categoriaExistente != null && categoriaExistente.equals(categoria)){
            throw new RegraException("Já existe uma categoria criada com esse nome");
        }*/

        Categoria categoriaNova = categoria.convertToModel();

        return categoriaRepository.save(categoriaNova);

    }

    public List<Categoria> listar(){
        return categoriaRepository.findAll();
    }

    public Categoria buscar(Long categoriaId){
        Categoria categoria = verificaExistencia(categoriaId);

        return categoria;
    }

    public Categoria atualizar(Long categoriaId, UpdateCategoriaRequestDto categoriaRequest){
        Categoria categoria = verificaExistencia(categoriaId);
        Categoria categoriaAtualizada = categoria.atualizaCategoria(categoriaRequest.getNome(),
                categoriaRequest.getDescricao());

        return categoriaRepository.save(categoriaAtualizada);
    }

    public void excluir(Long categoriaId){

        verificaExistencia(categoriaId);

        categoriaRepository.deleteById(categoriaId);
    }

    public Categoria verificaExistencia(Long categoriaId){
        Optional<Categoria> categoria = categoriaRepository.findById(categoriaId);

        if(categoria.isEmpty()){
            throw new RegraException("Categoria não encontrada");
        }

        return categoria.get();
    }


}
