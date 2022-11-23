package com.dto.command;

import com.model.Caracteristica;

import java.io.Serializable;

public class CaracteristicaDTO implements Serializable {
    public static final int NOMBRE_MAX_LENGTH = 45;
    public static final int DESCRIPCION_MAX_LENGTH = 100;
    private Long id;
    private String nombre;
    private String descripcion;

    public CaracteristicaDTO(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public Caracteristica newCaracteristica() {
        return new Caracteristica( this.id , this.nombre, this.descripcion);
    }

    public CaracteristicaDTO update(Caracteristica caracteristica){
        if (this.nombre!= null && nombre.length() <= NOMBRE_MAX_LENGTH)
            caracteristica.setNombre(this.nombre);
        if (this.descripcion != null && descripcion.length() <= DESCRIPCION_MAX_LENGTH)
            caracteristica.setDescripcion(this.descripcion);
        return new CaracteristicaDTO(caracteristica.getId(), caracteristica.getNombre(), caracteristica.getDescripcion());
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
