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

    @OneToOne
    @JoinColumn(name = "imagen_id",referencedColumnName = "id")
    private Imagen imagen;

    @OneToMany(mappedBy = "categoria")
    @JsonIgnore
    private Set<Producto> productos = new HashSet<>();

    public Categoria() {
    }

    public Categoria(Long id, String titulo, String descripcion, Imagen imagen) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public Categoria(String titulo, String descripcion, Imagen imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public Categoria(CategoriaDTO dto) {
        this.id = dto.getId();
        this.titulo = dto.getTitulo();
        this.descripcion = dto.getDescripcion();
    }

    public Categoria update(CategoriaDTO dto){
        if (dto.getTitulo() != null )
            this.titulo = dto.getTitulo();
        if (dto.getDescripcion() != null)
            this.descripcion = dto.getDescripcion();

        return new Categoria(this.id, this.titulo, this.descripcion, this.imagen );
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

    public Imagen getImagen() {
        return this.imagen;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public void setId(Long id) {
        this.id = id;
    }

}