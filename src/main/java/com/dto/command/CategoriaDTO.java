package com.dto.command;

import com.model.Categoria;
import com.model.Imagen;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    public static final int DESCRIPTION_MAX_LENGTH = 300;
    public static final int TITULO_MAX_LENGTH = 45;
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
    public Categoria newCategoria(Imagen imagen) {
        return new Categoria( this.id , this.titulo, this.descripcion, imagen);
    }

    public CategoriaDTO update(Categoria categoria){
        if (this.titulo!= null && titulo.length() <= TITULO_MAX_LENGTH)
            categoria.setTitulo(this.titulo);
        if (this.descripcion != null && descripcion.length() <= DESCRIPTION_MAX_LENGTH)
            categoria.setDescripcion(this.descripcion);
        Long id = ( this.imagenId == null )? categoria.getImagen().getId() : this.imagenId;

        return new CategoriaDTO(categoria.getId(), categoria.getTitulo(), categoria.getDescripcion(), id );
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
