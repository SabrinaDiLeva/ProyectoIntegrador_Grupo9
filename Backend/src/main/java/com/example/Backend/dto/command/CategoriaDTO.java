package com.example.Backend.dto.command;
import com.example.Backend.model.Categoria;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    public static final int DESCRIPTION_MAX_LENGTH = 100;
    public static final int TITULO_MAX_LENGTH = 45;
    public static final int URL_MAX_LENGTH=300;
    private Long id;
    private String titulo;
    private String descripcion;
    private String url;

    public CategoriaDTO(){

    }
    public CategoriaDTO(Long id, String titulo, String descripcion, String url){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
    }
    public Categoria newCategoria() {
        return new Categoria( this.id , this.titulo, this.descripcion, this.url);
    }

    public CategoriaDTO update(Categoria categoria){
        if (this.titulo!= null && titulo.length() <= TITULO_MAX_LENGTH)
            categoria.setTitulo(this.titulo);
        if (this.descripcion != null && descripcion.length() <= DESCRIPTION_MAX_LENGTH)
            categoria.setDescripcion(this.descripcion);
        if (this.url != null && url.length() <= URL_MAX_LENGTH)
            categoria.setDescripcion(this.descripcion);

        return new CategoriaDTO(categoria.getId(), categoria.getTitulo(), categoria.getDescripcion(), categoria.getImagen() );
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagenId() {
        return url;
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

    public void setImagenId(String imagen) {
        this.url = imagen;
    }

}
