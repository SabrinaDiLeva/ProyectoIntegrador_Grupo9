package com.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name="imagen")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String url;

    @ManyToOne
    @JoinColumn(name = "producto_id",referencedColumnName = "id")
    private Producto producto;

    public Imagen() {
    }

    public Imagen(Long id, String titulo, String url) {
        this.id = id;
        this.titulo = titulo;
        this.url = url;
    }


    public Imagen(Long id, String titulo, String url, Producto producto) {
        this.id = id;
        this.titulo = titulo;
        this.url = url;
        this.producto = producto;
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

    public Imagen update(Imagen imagen) {
        if ( imagen.getTitulo() != null )
          this.titulo = imagen.getTitulo();
        if ( imagen.getUrl() != null )
            this.url = imagen.getUrl();
        return this;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
