package com.example.Backend.model;

import javax.persistence.*;
import java.time.LocalDateTime;


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

    //relacion con usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id",referencedColumnName = "id")
    private Usuario usuario;

    //relacion con producto
    @ManyToOne
    @JoinColumn(name = "producto_id",referencedColumnName = "id")
    private Producto producto;

    public Reserva(){

    }

    public Reserva(Long id, LocalDateTime inicio, LocalDateTime fin, Usuario usuario, Producto producto){
        this.id=id;
        this.inicio=inicio;
        this.fin=fin;
        this.usuario=usuario;
        this.producto=producto;
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

    public Usuario getUsuario(){
        return usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario=usuario;
    }

    public Producto getProducto(){
        return producto;
    }

    public void setProducto(Producto producto){
        this.producto=producto;
    }
}
