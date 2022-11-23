package com.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    //relacion con usuario
    @OneToMany(mappedBy = "rol")
    @JsonIgnore
    private Set<Usuario> usuarios = new HashSet<>();
    
    public Rol(){

    }

    public Rol(Long id, String nombre){
        this.id=id;
        this.nombre=nombre;
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
}
