package com.dto.command;

import com.model.Categoria;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private Long id;
    private String titulo;
    private String descripcion;
    private String urlImagen;

    public CategoriaDTO(Long id, String titulo, String descripcion, String url_imagen ){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = url_imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

}
