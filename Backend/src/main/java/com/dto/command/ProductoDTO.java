package com.dto.command;

import com.model.Categoria;
import com.model.Ciudad;
import com.model.Producto;

import java.io.Serializable;

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
    private String fechas_disponibles;
    private String normas;
    private String seguridad;
    private String cancelacion;
    private Long ciudadId;
    private Long categoriaId;

    public ProductoDTO(Long id, String nombre, int calificacion, String titulo, String descripcion, String fechas_disponibles, String normas, String seguridad, String cancelacion, Long categoriaId, Long ciudadId) {
        this.id = id;
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechas_disponibles = fechas_disponibles;
        this.normas = normas;
        this.seguridad = seguridad;
        this.cancelacion = cancelacion;
        this.ciudadId = ciudadId;
        this.categoriaId = categoriaId;
    }
    public Producto newProducto(Categoria categoria, Ciudad ciudad) {
        return new Producto( this.id , this.nombre,this.calificacion,this.titulo,this.descripcion,this.fechas_disponibles,this.normas,this.seguridad,this.cancelacion,categoria,ciudad);
    }

    public ProductoDTO update(Producto producto){
        if (this.nombre!= null && nombre.length() <= NOMBRE_MAX_LENGTH)
            producto.setNombre(this.nombre);
        if (this.titulo != null && titulo.length() <= TITULO_MAX_LENGTH)
            producto.setTitulo(this.titulo);
        Long ciudadId = ( this.ciudadId == null )? producto.getCiudad().getId() : this.ciudadId;
        Long categoriaId = ( this.categoriaId == null )? producto.getCategoria().getId() : this.categoriaId;
        return new ProductoDTO(producto.getId(), producto.getNombre(),producto.getCalificacion(), producto.getTitulo(), producto.getDescripcion(), producto.getFechasDisponibles(), producto.getNormas(), producto.getSeguridad(), producto.getCancelacion(), categoriaId,ciudadId );
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

    public String getFechas_disponibles() {
        return fechas_disponibles;
    }

    public void setFechas_disponibles(String fechas_disponibles) {
        this.fechas_disponibles = fechas_disponibles;
    }

    public String getNormas() {
        return normas;
    }

    public void setNormas(String normas) {
        this.normas = normas;
    }

    public String getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(String seguridad) {
        this.seguridad = seguridad;
    }

    public String getCancelacion() {
        return cancelacion;
    }

    public void setCancelacion(String cancelacion) {
        this.cancelacion = cancelacion;
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
