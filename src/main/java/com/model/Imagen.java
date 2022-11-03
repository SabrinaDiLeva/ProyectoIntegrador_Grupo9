package com.model;

import javax.persistence.*;

@Entity
@Table(name="imagen")
public class Imagen {
    @Id
    @SequenceGenerator(name="imagen_sequence", sequenceName = "imagen_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imagen_sequence")
    private Long id;

    @Column
    private String titulo;

    @Column
    private String url;

    @ManyToOne
    @JoinColumn(name = "producto_id",referencedColumnName = "id")
    private Producto producto;

    @OneToOne(mappedBy = "imagen")
    private Categoria categoria;


    public Imagen() {
    }

    public Imagen(Long id, String titulo, String url) {
        this.id = id;
        this.titulo = titulo;
        this.url = url;
    }

    public Imagen(Long id, String url) {
        this.id = id;
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
}
