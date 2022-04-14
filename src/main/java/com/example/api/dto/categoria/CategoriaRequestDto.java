package com.example.api.dto.categoria;

public class CategoriaRequestDto {

    private Long id;

    public CategoriaRequestDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public CategoriaRequestDto() {
    }
}
