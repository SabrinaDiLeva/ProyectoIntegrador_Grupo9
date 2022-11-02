package com.model;

import javax.persistence.*;

@Entity
@Table(name="Ciudad")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_ciudad_sequence")
    @SequenceGenerator(name = "id_ciudad_sequence", sequenceName ="id_categoria_sequence",allocationSize = 1)
    private Long id;

    @Column
    private String nombre_ciudad;

    @Column
    private String pais;

    public Ciudad() {
    }

    public Ciudad(Long id, String nombre_ciudad, String pais) {
        this.id = id;
        this.nombre_ciudad = nombre_ciudad;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
