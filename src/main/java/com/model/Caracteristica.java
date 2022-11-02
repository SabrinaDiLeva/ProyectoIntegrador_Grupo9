package com.model;

import javax.persistence.*;

@Entity
@Table(name="caracteristica")
public class Caracteristica {
    @Id
    @SequenceGenerator(name="caracteristica_sequence", sequenceName = "caracteristica_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caracteristica_sequence")
    private Long id;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    public Caracteristica(){

    }
    public Caracteristica(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
