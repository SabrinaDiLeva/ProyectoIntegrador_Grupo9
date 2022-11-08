import React from "react";
import style from "./tarjetaProducto.module.css";
import { Link } from "react-router-dom";


export default function TarjetaProducto(props) {
    return(
        <>
        <div className={style.container}>
            <div className={style.header}>
                <span className={style.headerIzquierda}>
                    <h3>{props.category}</h3>
                    <h1>{props.name}</h1>
                </span>
                <span className={style.headerDerecha}>
                    <button id={style.buttonHome} className={style.button} type="button">back<Link to='/'></Link></button>
                </span>
            </div>

            <div className={style.subHeader}>
                <span className={style.subHeaderIzquierda}>
                    <h3>{props.category}</h3>
                    <h1>{props.name}</h1>
                </span>
                <span className={style.subHeaderDerecha}>
                    <button id={style.buttonHome} className={style.button} type="button">back<Link to='/'></Link></button>
                </span>
            </div>

            <div className={style.contenedorImagenes}>
                <span className={style.contenedorImgIzquierda}>
                    <img className={style.imagenIzquierda} src={props.imagen} alt="imagenProductoIzquierda"></img>
                </span>

                <span className={style.contenedorImgDerecha}>
                    <span className={style.subContenedorImgDerecha}>
                        <img className={style.imagenDerecha} src={props.imagen} alt="imagenProductoDerecha"></img>
                        <img className={style.imagenDerecha} src={props.imagen} alt="imagenProductoDerecha"></img>
                    </span>
                    <span className={style.subContenedorImgDerecha}>
                        <img className={style.imagenDerecha} src={props.imagen} alt="imagenProductoDerecha"></img>
                        <img className={style.imagenDerecha} src={props.imagen} alt="imagenProductoDerecha"></img>
                    </span>
                </span>
                
            </div>
            
            {/* key
            imagen
            category
            name
            title
            location
            description
            calificacion */}
                        
            
            <div>
            </div>

        </div>
        </>
    )
}
