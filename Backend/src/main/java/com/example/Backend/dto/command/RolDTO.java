package com.example.Backend.dto.command;

import com.example.Backend.model.Rol;

public class RolDTO {
    public static final int NOMBRE_MAX_LENGTH = 45;

    private Long id;
    private String nombre;

    public RolDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Rol newUsuario(Rol rol) {
        return new Rol( this.id , this.nombre);
    }

    public RolDTO update(RolDTO rolDTO){
        if (this.nombre!= null && nombre.length() <= NOMBRE_MAX_LENGTH)
            rolDTO.setNombre(this.nombre);
        return new RolDTO(rolDTO.getId(), rolDTO.getNombre());
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