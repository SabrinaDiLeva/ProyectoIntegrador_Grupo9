package com.example.Backend.dto.command;

import com.example.Backend.model.*;

import java.io.Serializable;
import java.util.Set;


public class ProductoDTO implements Serializable {
    public static final int NOMBRE_MAX_LENGTH = 45;
    public static final int TITULO_MAX_LENGTH = 45;
    public static final int DESCRIPCION_MAX_LENGTH = 500;
    public static final int FECHAS_MAX_LENGTH = 500;
    public static final int NORMAS_MAX_LENGTH = 500;
    public static final int SEGURIDAD_MAX_LENGTH = 500;
    public static final int CANCELACION_MAX_LENGTH = 500;

    private Long id;
    private String nombre;
    private int calificacion;
    private String titulo;
    private String descripcion;
    private Set<Caracteristica> caracteristicas;
    private Set<Fecha> fechas_disponibles;
    private Set<Norma> normas;
    private Set<Seguridad> seguridad;
    private Set<Cancelacion> cancelacion;
    private Long ciudadId;
    private Long categoriaId;

    public ProductoDTO(){

    }
    public ProductoDTO(Long id, String nombre, int calificacion, String titulo, String descripcion, Long categoriaId, Long ciudadId) {
        this.id = id;
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ciudadId = ciudadId;
        this.categoriaId = categoriaId;
    }


    public ProductoDTO(Long id, String nombre, int calificacion, String titulo, String descripcion, Long categoriaId, Long ciudadId, Set<Caracteristica> caracteristicas,Set<Fecha>fechas,Set<Norma> normas, Set<Seguridad> seguridad, Set<Cancelacion> cancelacion ) {
        this.id = id;
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ciudadId = ciudadId;
        this.categoriaId = categoriaId;
        this.caracteristicas=caracteristicas;
        this.fechas_disponibles=fechas;
        this.normas=normas;
        this.seguridad=seguridad;
        this.cancelacion=cancelacion;
    }

    public Producto newProducto(Categoria categoria, Ciudad ciudad) {
        return new Producto( this.id , this.nombre,this.calificacion,this.titulo,this.descripcion,categoria,ciudad, this.caracteristicas,this.fechas_disponibles,this.normas,this.seguridad,this.cancelacion);
    }

    public ProductoDTO update(Producto producto){
        if (this.nombre!= null && nombre.length() <= NOMBRE_MAX_LENGTH)
            producto.setNombre(this.nombre);
        if (this.titulo != null && titulo.length() <= TITULO_MAX_LENGTH)
            producto.setTitulo(this.titulo);
        Long ciudadId = ( this.ciudadId == null )? producto.getCiudad().getId() : this.ciudadId;
        Long categoriaId = ( this.categoriaId == null )? producto.getCategoria().getId() : this.categoriaId;
        return new ProductoDTO(producto.getId(), producto.getNombre(),producto.getCalificacion(), producto.getTitulo(), producto.getDescripcion(), categoriaId,ciudadId );
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

    public Long getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Long ciudadId) {
        this.ciudadId = ciudadId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
