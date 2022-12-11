package com.example.Backend.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToOne
    @JoinColumn(name = "rol_id",referencedColumnName = "id")
    private Rol rol;


    //relacion con reserva
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private Set<Reserva> reservas = new HashSet<>();

    public Usuario(){

    }

    public Usuario(Long id, String nombre, String apellido, String email, String contrasenia, String ciudad, Rol rol){
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
        this.contrasenia=contrasenia;
        this.ciudad=ciudad;
        this.rol=rol;
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

    public Rol getRol(){
        return rol;
    }

    public void setRol(Rol rol){
        this.rol=rol;
    }
}
