package com.dto.command;

import com.model.Categoria;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private Long id;
    private String titulo;
    private String descripcion;
    private Long imagenId;

    public CategoriaDTO(Long id, String titulo, String descripcion, Long imagenId){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagenId = imagenId;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Long getImagenId() {
        return imagenId;
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

    public void setImagenId(Long imagenId) {
        this.imagenId = imagenId;
    }

}
