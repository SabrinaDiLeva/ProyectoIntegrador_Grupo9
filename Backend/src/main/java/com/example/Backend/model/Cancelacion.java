package com.example.Backend.model;

import javax.persistence.*;
import java.util.HashSet;

import java.util.Set;

@Entity
@Table(name="cancelacion")
public class Cancelacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String politica;

    public Cancelacion(){

    }

    public Cancelacion(Long id, String politica){
        this.id=id;
        this.politica=politica;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolitica(){
        return politica;
    }

    public void setPolitica(String politica){
        this.politica=politica;
    }
}
