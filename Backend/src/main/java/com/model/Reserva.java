package com.model;
import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime inicio;

    @Column
    private LocalDateTime fin;
    
    //relacion con producto

    //relacion con usuario

    public Reserva(){

    }

    public Reserva(Long id, LocalDateTime inicio, LocalDateTime fin){
        this.id=id;
        this.inicio=inicio;
        this.fin=fin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getInicio(){
        return inicio;
    }

    public void setInicio(LocalDateTime inicio){
        this.inicio=inicio;
    }

    public LocalDateTime getFin(){
        return fin;
    }

    public void setFin(LocalDateTime fin){
        this.fin=fin;
    }
}
