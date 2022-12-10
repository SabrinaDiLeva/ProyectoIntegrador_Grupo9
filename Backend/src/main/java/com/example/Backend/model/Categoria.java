package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="categoria")
public class Categoria {
    @Id
    //@GeneratedValue(strategy= GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String descripcion;

    @Column
    private String url_imagen;

    @OneToMany(mappedBy = "categoria")
    @JsonIgnore
    private Set<Producto> productos = new HashSet<>();

    public Categoria() {
    }

    public Categoria(Long id, String titulo, String descripcion, String url) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url_imagen = url;
    }

    /*public Categoria(String titulo, String descripcion, Imagen imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }*/

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagen() {
        return this.url_imagen;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagen(String imagen) {
        this.url_imagen = imagen;
    }

    public void setId(Long id) {
        this.id = id;
    }

}