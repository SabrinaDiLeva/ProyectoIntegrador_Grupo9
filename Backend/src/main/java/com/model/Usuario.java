package com.model;
import javax.persistence.*;
@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String email;

    @Column
    private String contrasenia;

    @Column
    private String ciudad;

    //relacion con rol

    //relacion con reserva

    public Usuario(){

    }

    public Usuario(Long id, String nombre, String apellido, String email, String contrasenia, String ciudad){
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
        this.contrasenia=contrasenia;
        this.ciudad=ciudad;

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
}
