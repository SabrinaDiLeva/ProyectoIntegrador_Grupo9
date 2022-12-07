import React from 'react';
import style from "./CrearProducto.module.css";
import Titulo from "../Tarjeta-Producto/subcomponents/Titulo"
import { Icons } from '../ui/icons';
import Boton from '../Botones/BotonLinkTo';


export default function CrearProducto() {

    return (
        <>
            <Titulo name={'Administracion de Productos'} />

            <div className={style.container}>
                <h1 className={style.titulo1}>Crear Propiedad</h1>

                <div className={style.subContainer}>
                    <form className={style.formulario}>
                        <div className={style.productoInfoContainer}>
                            <span className={style.infoContainer1}>
                                <label className={style.infoLabel}>Nombre de la Propiedad</label>
                                <input type="text" className={style.infoInput} autoComplete='off' placeholder='Hotel Hermitage'></input>
                                
                                <label className={style.infoLabel}>Categoria</label>
                                <input type="text" className={style.infoInput} autoComplete='off' placeholder='Hotel'></input>
                                
                                <label className={style.infoLabel}>Direccion</label>
                                <input type="text" className={style.infoInput} autoComplete='off' placeholder='Av. Colon 1643'></input>
                                
                                <label className={style.infoLabel}>Ciudad</label>
                                <input type="text" className={style.infoInput} autoComplete='off' placeholder='Ciudad'></input>
                            </span>
                            <span className={style.infoContainer2}>
                                <label className={style.infoLabel}>Descripcion</label>
                                <input type="text" className={style.descriptionInput} autoComplete='off' placeholder='Escriba aqui'></input>
                            </span>
                        </div>

                        <h2 className={style.titulo2}>Agregar Atributos</h2>
                        <div className={style.productoCaracteristicasContainer}>
                            <span className={style.caracteristicasContainer}>
                                <label className={style.caracteristicaLabel}>Nombre</label>
                                <input type="text" className={style.caracteristicaInput} autoComplete='off' placeholder='Wifi'></input>
                            </span>
                            <span className={style.buttonAgregarContainer}>
                                <button className={style.buttonAgregar}>{Icons.agregar}</button>
                            </span>
                            <span className={style.caracteristicasContainer}>
                                <label className={style.caracteristicaLabel}>Icono</label>
                                <input type="text" className={style.caracteristicaInput} autoComplete='off' placeholder='WiFi'></input>
                            </span>
                        </div>


                        <h2 className={style.titulo2}>Politicas del Producto</h2>
                        <div className={style.productoPoliticasContainer}>
                            <span className={style.politicaContainer}>
                                <h3 className={style.titulo3}>Normas de la Casa</h3>
                                <label className={style.politicaLabel}>Descripcion</label>
                                <input type="text" className={style.politicaInput} autoComplete='off' placeholder='Escriba aqui'></input>
                            </span>

                            <span className={style.politicaContainer}>
                                <h3 className={style.titulo3}>Salud y Seguridad</h3>
                                <label className={style.politicaLabel}>Descripcion</label>
                                <input type="text" className={style.politicaInput} autoComplete='off' placeholder='Escriba aqui'></input>
                            </span>

                            <span className={style.politicaContainer}>
                                <h3 className={style.titulo3}>Politicas de Cancelacion</h3>
                                <label className={style.politicaLabel}>Descripcion</label>
                                <input type="text" className={style.politicaInput} autoComplete='off' placeholder='Escriba aqui'></input>
                            </span>
                        </div>    

                        <h2 className={style.titulo2}>Cargar Imagenes</h2>
                        <span className={style.imagenContainer}>
                            <input type="url" className={style.imagenInput} autoComplete='off' placeholder='Insertar htttps://'></input>
                            <button className={style.button}>{Icons.agregar}</button>
                        </span>

                    </form>
                    <div className={style.BotonContainer}>
                        <Boton to={`/crearproducto/exito`} text={"Crear Producto"} />
                    </div>
                </div>
            </div>
        </>
    )
}