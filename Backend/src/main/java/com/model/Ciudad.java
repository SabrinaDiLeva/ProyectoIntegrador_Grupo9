package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="ciudad")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ciudad;

    @Column
    private String pais;

    @OneToMany(mappedBy = "ciudad")
    @JsonIgnore
    private Set<Producto> productos = new HashSet<>();

    public Ciudad(){

    }
    public Ciudad(Long id, String nombre, String pais) {
        this.id = id;
        this.ciudad = nombre;
        this.pais = pais;
    }

    public Ciudad update(Ciudad ciudad){
        if( ciudad.getNombre() != null)
            this.ciudad = ciudad.getNombre();
        if( ciudad.getPais() != null )
            this.pais = ciudad.getPais();

        return new Ciudad(this.id,this.ciudad, this.pais);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return ciudad;
    }

    public void setNombre(String nombre) {
        this.ciudad = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
