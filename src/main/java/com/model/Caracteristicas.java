package com.model;
import javax.persistence.*;

@Entity
@Table(name="Caracteristicas")
public class Caracteristicas {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_Caracteristica_sequence")
    @SequenceGenerator(name = "id_Caracteristica_sequence",sequenceName = "id_Caracteristicas_sequence",allocationSize = 1)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    public Caracteristicas() {
    }

    public Caracteristicas(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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
