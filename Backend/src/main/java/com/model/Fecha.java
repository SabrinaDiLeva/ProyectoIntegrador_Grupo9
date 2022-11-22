package com.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="fecha")
public class Fecha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate fecha;
    
    public Fecha(){

    }

    public Fecha(Long id, LocalDate fecha){
        this.id=id;
        this.fecha=fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha(){
        return fecha;
    }

    public void setFecha(LocalDate fecha){
        this.fecha=fecha;
    }
}
