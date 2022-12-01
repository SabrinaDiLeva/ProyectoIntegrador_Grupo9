package com.dto.command;

import java.io.Serializable;

import com.model.Rol;
import com.model.Usuario;

public class UsuarioDTO implements Serializable {
    public static final int NOMBRE_MAX_LENGTH = 45;
    public static final int APELLIDO_MAX_LENGTH = 45;
    public static final int EMAIL_MAX_LENGTH = 100;
    public static final int CONTRASENIA_MAX_LENGTH = 15;
    public static final int CIUDAD_MAX_LENGTH = 45;

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasenia;
    private String ciudad;
    private Long rol_id;

    public UsuarioDTO(){
        
    }
    public UsuarioDTO(Long id, String nombre, String apellido, String email, String contrasenia, String ciudad, Long rol_id){
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
        this.contrasenia=contrasenia;
        this.ciudad=ciudad;
        this.rol_id=rol_id;
    }

    public Usuario newUsuario(Rol rol) {
        return new Usuario( this.id , this.nombre,this.apellido,this.email,this.contrasenia,this.ciudad,rol);
    }

    public UsuarioDTO update(Usuario usuario){
        if (this.nombre!= null && nombre.length() <= NOMBRE_MAX_LENGTH)
            usuario.setNombre(this.nombre);
        if (this.apellido!= null && apellido.length() <= APELLIDO_MAX_LENGTH)
            usuario.setApellido(this.apellido);
        if (this.email!= null && email.length() <= EMAIL_MAX_LENGTH)
            usuario.setEmail(this.email);
        if (this.contrasenia!= null && contrasenia.length() <= CONTRASENIA_MAX_LENGTH)
            usuario.setContrasenia(this.contrasenia);
        if (this.ciudad!= null && ciudad.length() <= CIUDAD_MAX_LENGTH)
            usuario.setCiudad(this.ciudad);
        Long rolId = ( this.rol_id == null )? usuario.getRol().getId() : this.rol_id;
        return new UsuarioDTO(usuario.getId(), usuario.getNombre(),usuario.getApellido(), usuario.getEmail(), usuario.getContrasenia(),usuario.getCiudad(), rolId );
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Long getRolId(){
        return this.rol_id;
    }

    public void setRolId(Long id){
        this.rol_id=id;
    }
}
