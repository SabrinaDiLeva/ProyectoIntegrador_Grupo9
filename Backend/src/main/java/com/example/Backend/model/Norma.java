package com.example.Backend.model;
import javax.persistence.*;


@Entity
@Table(name="norma")
public class Norma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String norma;

    public Norma(){

    }

    public Norma(Long id, String norma){
        this.id=id;
        this.norma=norma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNorma(){
        return norma;
    }

    public void setNorma(String norma){
        this.norma=norma;
    }
}
