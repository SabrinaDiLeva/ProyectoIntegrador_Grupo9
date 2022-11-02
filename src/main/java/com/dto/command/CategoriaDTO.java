package com.dto.command;

import com.model.Categoria;

public class CategoriaDTO {
    private String titulo;
    private String descripcion;
    private String url_imagen;
    public CategoriaDTO(String titulo, String descripcion, String url_imagen ){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url_imagen = url_imagen;
    }

    public Categoria Categoria(Long id){
        return new Categoria(id, this.titulo, this.descripcion, this.url_imagen);
    }

    public Categoria Categoria() {
        return new Categoria( this.titulo, this.descripcion, this.url_imagen);
    }



}
