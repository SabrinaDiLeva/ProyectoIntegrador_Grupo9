package com.model;

import javax.persistence.*;

@Entity
@Table(name="categorias")
public class Categoria {
    @Id
    @SequenceGenerator(name="categoria_sequence", sequenceName = "categoria_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_sequence")
    private Long id;

    @Column
    private String titulo;

    @Column
    private String descripcion;

    @Column
    private String url_imagen;

    public Categoria() {
    }

    public Categoria(Long id, String titulo, String descripcion, String url_imagen) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url_imagen = url_imagen;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }
}
