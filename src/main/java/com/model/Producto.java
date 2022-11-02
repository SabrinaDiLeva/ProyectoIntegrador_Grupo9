package com.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="producto")
public class Producto {
    @Id
    @SequenceGenerator(name="producto_sequence", sequenceName = "producto_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_sequence")
    private Long id;

    @Column
    private String nombre;
    @Column
    private int calificacion;
    @Column
    private String titulo;
    @Column
    private String descripcion;
    @Column
    private List<Date> fechas_disponibles;
    @Column
    private List<String>normas;
    @Column
    private List<String>seguridad;
    @Column
    private String cancelacion;

    public Producto(){

    }

    public Producto(Long id, String nombre, int calificacion, String titulo, String descripcion, List<Date> fechas_disponibles, List<String> normas, List<String> seguridad, String cancelacion) {
        this.id = id;
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechas_disponibles = fechas_disponibles;
        this.normas = normas;
        this.seguridad = seguridad;
        this.cancelacion = cancelacion;
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

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Date> getFechas_disponibles() {
        return fechas_disponibles;
    }

    public void setFechas_disponibles(List<Date> fechas_disponibles) {
        this.fechas_disponibles = fechas_disponibles;
    }

    public List<String> getNormas() {
        return normas;
    }

    public void setNormas(List<String> normas) {
        this.normas = normas;
    }

    public List<String> getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(List<String> seguridad) {
        this.seguridad = seguridad;
    }

    public String getCancelacion() {
        return cancelacion;
    }

    public void setCancelacion(String cancelacion) {
        this.cancelacion = cancelacion;
    }
}
