package com.dto.command;

import com.model.Categoria;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private String titulo;
    private String descripcion;
    private String urlImagen;

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public CategoriaDTO(String titulo, String descripcion, String url_imagen ){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = url_imagen;
    }

}
