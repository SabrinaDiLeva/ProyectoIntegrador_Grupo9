package com.dto.command;

import com.model.Ciudad;

import java.io.Serializable;

public class CiudadDTO implements Serializable {
    public static final int NOMBRE_MAX_LENGTH = 45;
    public static final int PAIS_MAX_LENGTH = 45;
    private Long id;
    private String nombre;
    private String pais;
    public CiudadDTO(){
        
    }
    public CiudadDTO(Long id, String nombre, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
    }
    public Ciudad newCiudad() {
        return new Ciudad( this.id , this.nombre, this.pais);
    }

    public CiudadDTO update(Ciudad ciudad){
        if (this.nombre!= null && nombre.length() <= NOMBRE_MAX_LENGTH)
            ciudad.setNombre(this.nombre);
        if (this.pais != null && pais.length() <= PAIS_MAX_LENGTH)
            ciudad.setPais(this.pais);
        return new CiudadDTO(ciudad.getId(), ciudad.getNombre(), ciudad.getPais());
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
