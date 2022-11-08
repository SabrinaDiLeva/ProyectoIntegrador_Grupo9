package com.dto.command;

import com.model.Categoria;
import com.model.Imagen;
import com.model.Producto;

import java.io.Serializable;

public class ImagenDTO implements Serializable {
    public static final int TITULO_MAX_LENGTH = 255;
    public static final int URL_MAX_LENGTH = 255;
    private Long id;
    private String titulo;
    private String url;
    private Long productoId;

    public ImagenDTO(Long id, String titulo, String url, Long productoId) {
        this.id = id;
        this.titulo = titulo;
        this.url = url;
        this.productoId = productoId;
    }

    public ImagenDTO(Long id, String url, Long productoId) {
        this.id = id;
        this.url = url;
        this.productoId = productoId;
    }
    public Imagen newImagen(Producto producto) {
        return new Imagen( this.id , this.titulo, this.url, producto);
    }

    public ImagenDTO update(Imagen imagen){
        if (this.titulo!= null && titulo.length() <= TITULO_MAX_LENGTH)
            imagen.setTitulo(this.titulo);
        if (this.url != null && url.length() <= URL_MAX_LENGTH)
            imagen.setUrl(this.url);
        Long id = ( this.productoId == null )? imagen.getProducto().getId() : this.productoId;

        return new ImagenDTO(imagen.getId(), imagen.getTitulo(), imagen.getUrl(), id );
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }
}
