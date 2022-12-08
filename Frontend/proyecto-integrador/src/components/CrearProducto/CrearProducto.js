import React, {useState, useEffect} from 'react';
import style from "./CrearProducto.module.css";
import Titulo from "../Tarjeta-Producto/subcomponents/Titulo"
import { Icons } from '../ui/icons';
import Boton from '../Botones/BotonLinkTo';
import { getCiudades } from "../../service/ciudadApi"
import { getCategorias } from "../../service/categoriaApi"
import ListadoCiudad from './subcomponentes/ListadoCiudad';
import ListadoCategoria from './subcomponentes/ListadoCategoria';

export default function CrearProducto() {
    const [searchTermCiudades, setSearchTermCiudades] = useState("");
    
    // Obtener Ciudades
    const handleChangeCiudades = event => {
        setSearchTermCiudades(event.target.value);
    };
    
    useEffect( () => {
        var listaCiudad = document.getElementById("inputListadoCiudad");
        listaCiudad.style.display = 'none';
        var inputCiudad = document.getElementById("infoInputCiudad");
        inputCiudad.addEventListener('focus', function () {
            listaCiudad.style.display = 'block';
        });
    
        inputCiudad.addEventListener('focusout', function () {
            listaCiudad.style.display = 'none';
        });
    }, [] );
    

    // Obtener Categorias
    const [searchTermCategoria, setSearchTermCategoria] = useState("");
    const handleChangeCategoria = event => {
        setSearchTermCategoria(event.target.value);
    };

    useEffect( () => {
        var listaCategoria = document.getElementById("inputListadoCategoria");
        listaCategoria.style.display = 'none';
        var inputCategoria = document.getElementById("infoInputCategoria");
        inputCategoria.addEventListener('focus', function () {
            listaCategoria.style.display = 'block';
        });
    
        inputCategoria.addEventListener('focusout', function () {
            listaCategoria.style.display = 'none';
        });
    }, [] );

    return (
        <>
            <Titulo name={'Administracion de Productos'} />

            <div className={style.container}>
                <h1 className={style.titulo1}>Crear Propiedad</h1>

                <div className={style.subContainer}>
                    <form className={style.formulario}>
                        <div className={style.productoInfoContainer}>
                            <div className={style.infoContainer1}>
                                <span className={style.infoLabelContainer}>
                                <label className={style.infoLabel}>Nombre de la Propiedad</label>
                                <input type="text" className={style.infoInput} autoComplete='off' placeholder='Hotel Hermitage'></input>
                                </span>

                                <span className={style.infoLabelContainer}>
                                    <label className={style.infoLabel}>Categoria</label>
                                    <span className={style.inputContainer}>
                                        <input type="search" id='infoInputCategoria' className={style.infoInput} autoComplete='off' value={searchTermCategoria} onChange={handleChangeCategoria} placeholder='Hotel'></input>
                                        <ul className={style.inputListado} id="inputListadoCategoria" >
                                            <ListadoCategoria />
                                        </ul>
                                    </span>
                                </span>

                                <span className={style.infoLabelContainer}>
                                    <label className={style.infoLabel}>Direccion</label>
                                    <input type="text" className={style.infoInput} autoComplete='off' placeholder='Av. Colon 1643'></input>
                                    </span>

                                <span className={style.infoLabelContainer}>
                                    <label className={style.infoLabel}>Ciudad</label>
                                    <span className={style.inputContainer}>
                                        <input type="search" id='infoInputCiudad' className={style.infoInput} autoComplete='off' value={searchTermCiudades} onChange={handleChangeCiudades} placeholder='Ciudad'></input>
                                        <ul className={style.inputListado} id="inputListadoCiudad" >
                                            <ListadoCiudad />
                                        </ul>
                                    </span>
                                </span>

                            </div>
                            <div className={style.infoContainer2}>
                                <label className={style.infoLabel}>Descripcion</label>
                                <input type="text" className={style.descriptionInput} autoComplete='off' placeholder='Escriba aqui'></input>
                            </div>
                        </div>

                        <h2 className={style.titulo2}>Agregar Atributos</h2>
                        <div className={style.productoCaracteristicasContainer}>
                            <div className={style.caracteristicasContainer1}>
                                <span className={style.caracteristicasSubContainer}>
                                    <label className={style.caracteristicaLabel}>Nombre</label>
                                    <input type="text" className={style.caracteristicaInput} autoComplete='off' placeholder='Wifi'></input>
                                </span>
                                <span className={style.caracteristicasSubContainer}>
                                    <label className={style.caracteristicaLabel}>Icono</label>
                                    <input type="text" className={style.caracteristicaInput} autoComplete='off' placeholder='WiFi'></input>
                                </span>
                            </div>
                            <div className={style.caracteristicasContainer2}>
                                <span className={style.buttonAgregarContainer}>
                                    <button className={style.buttonAgregar}>{Icons.agregar}</button>
                                </span>
                            </div>
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