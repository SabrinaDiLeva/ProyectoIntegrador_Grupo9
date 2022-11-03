package com.model;

import com.dto.command.CategoriaDTO;

import javax.persistence.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria(CategoriaDTO dto) {
        this.titulo = dto.getTitulo();
        this.descripcion = dto.getDescripcion();
        this.urlImagen = dto.getUrlImagen();
    }
    public Categoria(Long id, CategoriaDTO dto) {
        this.id = id;
        this.titulo = dto.getTitulo();
        this.descripcion = dto.getDescripcion();
        this.urlImagen = dto.getUrlImagen();
    }

}