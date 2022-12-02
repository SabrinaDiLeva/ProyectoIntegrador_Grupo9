package com.example.Backend.dto.command;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.example.Backend.model.Producto;
import com.example.Backend.model.Reserva;
import com.example.Backend.model.Usuario;

public class ReservaDTO implements Serializable {
    private Long id;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private Long usuarioId;
    private Long productoId;

    public ReservaDTO(){

    }
    public ReservaDTO(Long id, LocalDateTime inicio, LocalDateTime fin, Long usuario, Long producto){
        this.id=id;
        this.inicio=inicio;
        this.fin=fin;
        this.usuarioId=usuario;
        this.productoId=producto;
    }

    public Reserva newReserva(Usuario usuario, Producto producto) {
        return new Reserva( this.id , this.inicio,this.fin,usuario, producto);
    }

    public ReservaDTO update(Reserva reserva){
        Long usuarioId = ( this.usuarioId == null )? reserva.getUsuario().getId() : this.usuarioId;
        Long productoId = ( this.productoId == null )? reserva.getProducto().getId() : this.productoId;
        return new ReservaDTO(reserva.getId(), reserva.getInicio(),reserva.getFin(),usuarioId,productoId);
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

    public Long getUsuario(){
        return usuarioId;
    }

    public void setUsuario(Long usuario){
        this.usuarioId=usuario;
    }

    public Long getProducto(){
        return productoId;
    }

    public void setProducto(Long producto){
        this.productoId=producto;
    }

}
