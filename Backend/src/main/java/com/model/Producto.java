package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;
    @Column
    private Integer calificacion;
    @Column
    private String titulo;
    @Column
    private String descripcion;
    //@Column(name = "fechas_disponibles")
    //private String fechasDisponibles;
    //@Column
    //private String normas;
    //@Column
    //private String seguridad;
    //@Column
    //private String cancelacion;


    @OneToMany(mappedBy = "producto")
    @JsonIgnore
    private Set<Imagen> imagens = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "categoria_id",referencedColumnName = "id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "ciudad_id",referencedColumnName = "id")
    private Ciudad ciudad;

    @ManyToMany
    @JoinTable(
            name = "producto_has_caracteristica",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "caracteristica_id")
    )
    private Set<Caracteristica> caracteristica = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name="producto_has_fecha",
            joinColumns = @JoinColumn(name="producto_id"),
            inverseJoinColumns = @JoinColumn(name="fecha_id")
    )
    private Set<Fecha> fecha = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name="producto_has_norma",
            joinColumns= @JoinColumn(name="producto_id"),
            inverseJoinColumns=@JoinColumn(name="norma_id")
    )
    private Set<Norma> norma = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name="producto_has_seguridad",
            joinColumns = @JoinColumn(name="producto_id"),
            inverseJoinColumns=@JoinColumn(name="seguridad_id")
    )
    private Set<Seguridad> seguridad = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name="producto_has_cancelacion",
            joinColumns = @JoinColumn(name="producto_id"),
            inverseJoinColumns = @JoinColumn(name="cancelacion_id")
    )
    private Set<Cancelacion> cancelacion=new HashSet<>();


    @OneToMany(mappedBy = "producto")
    @JsonIgnore
    private Set<Reserva> reservas = new HashSet<>();


    public Producto() {

    }

    public Producto(Long id, String nombre, Integer calificacion, String titulo, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Producto(Long id, String nombre, Integer calificacion, String titulo, String descripcion, Categoria categoria, Ciudad ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.ciudad = ciudad;
    }

    public Producto(Long id, String nombre, Integer calificacion, String titulo, String descripcion, Categoria categoria, Ciudad ciudad, Set<Caracteristica> caracteristicas, Set<Fecha> fechas, Set<Norma> normas, Set<Seguridad> seguridad, Set<Cancelacion> cancelacion) {
        this.id = id;
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.ciudad = ciudad;
        this.caracteristica=caracteristicas;
        this.fecha=fechas;
        this.norma=normas;
        this.seguridad=seguridad;
        this.cancelacion=cancelacion;
    }

    public Producto update(Producto producto){
        if( producto.getNombre() != null )
            this.nombre = producto.getNombre();
        if( producto.getCalificacion() != null )
            this.calificacion = producto.getCalificacion();
        if( producto.getTitulo() != null )
            this.titulo = producto.getTitulo();
        if( producto.getDescripcion() != null)
            this.descripcion = producto.getDescripcion();
        if( producto.getCategoria() != null )
            this.categoria = producto.getCategoria();
        if( producto.getCiudad() != null )
            this.ciudad = producto.getCiudad();
        
        return new Producto(this.id, this.nombre, this.calificacion, this.titulo, this.descripcion, this.categoria, this.ciudad );
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

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setImagens(Set<Imagen> imagens) {
        this.imagens = imagens;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public void setCaracteristica(Set<Caracteristica> caracteristica) {
        this.caracteristica = caracteristica;
    }

    public void setCalificacion(Integer calificacion) {
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

    public Set<Fecha> getFechasDisponibles() {
        return fecha;
    }

    public void setFechasDisponibles(Set<Fecha> fechasDisponibles) {
        this.fecha = fechasDisponibles;
    }

    public Set<Norma> getNormas() {
        return norma;
    }

    public void setNormas(Set<Norma> norma) {
        this.norma = norma;
    }

    public Set<Seguridad> getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(Set<Seguridad> seguridad) {
        this.seguridad = seguridad;
    }

    public Set<Cancelacion> getCancelacion() {
        return cancelacion;
    }

    public Set<Imagen> getImagens() {
        return imagens;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public Set<Caracteristica> getCaracteristica() {
        return caracteristica;
    }

    public void setCancelacion(Set<Cancelacion> cancelacion) {
        this.cancelacion = cancelacion;
    }
}
