package com.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="seguridad")
public class Seguridad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String politica;

    public Seguridad(){

    }

    public Seguridad(Long id, String politica){
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
