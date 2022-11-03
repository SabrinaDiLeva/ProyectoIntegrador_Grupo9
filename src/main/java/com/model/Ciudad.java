package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="ciudad")
public class Ciudad {
    @Id
    @SequenceGenerator(name="ciudad_sequence", sequenceName = "ciudad_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ciudad_sequence")
    private Long id;

    @Column
    private String nombre;

    @Column
    private String pais;

    @OneToMany(mappedBy = "ciudad")
    @JsonIgnore
    private Set<Producto> productos = new HashSet<>();

    public Ciudad(){

    }
    public Ciudad(Long id, String nombre, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
