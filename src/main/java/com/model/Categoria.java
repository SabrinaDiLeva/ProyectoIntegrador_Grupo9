package com.model;

import com.dto.command.CategoriaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="categoria")
public class Categoria {
    @Id
    //@GeneratedValue(strategy= GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_categoria_sequence")
    @SequenceGenerator(name = "id_categoria_sequence", sequenceName = "id_categoria_sequence", allocationSize = 1)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String descripcion;

    @Column
    private String urlImagen;

    @OneToOne
    @JoinColumn(name = "imagen_id",referencedColumnName = "id")
    private Imagen imagen;

    @OneToMany(mappedBy = "categoria")
    @JsonIgnore
    private Set<Producto> productos = new HashSet<>();

    public Categoria() {
    }

    public Categoria(Long id, String titulo, String descripcion, String url_imagen) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = url_imagen;
    }

    public Categoria(String titulo, String descripcion, String url_imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = url_imagen;
    }

    public Categoria(CategoriaDTO dto) {
        this.id = dto.getId();
        this.titulo = dto.getTitulo();
        this.descripcion = dto.getDescripcion();
        this.urlImagen = dto.getUrlImagen();
    }

    public Categoria update(CategoriaDTO dto){
        if (!dto.getTitulo().isEmpty())
            this.titulo = dto.getTitulo();
        if (!dto.getDescripcion().isEmpty())
            this.descripcion = dto.getDescripcion();
        if (!dto.getUrlImagen().isEmpty())
            this.urlImagen = dto.getUrlImagen();

        return new Categoria(this.id, this.titulo, this.descripcion, this.urlImagen );
    }
    public Long getId() {
        return id;
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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public void setId(Long id) {
        this.id = id;
    }

}