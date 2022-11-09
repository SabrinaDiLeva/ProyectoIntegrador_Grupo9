import React, {useState} from 'react';
import style from "./tarjetaProducto.module.css";
import { Link } from "react-router-dom";
import { DateRange } from 'react-date-range';
import {addDays} from 'date-fns'
import { Icons } from '../ui/icons';

export default function TarjetaProducto(props) {

    const [range, setRange] = useState([
        {
            startDate: new Date(),
            endDate: addDays(new Date(), 7),
            key: 'selection'
        }
    ]);

    const totalStars = 5;
    const activeStars = props.calificacion;

    return(
        <>
        <div className={style.container}>
            <div className={style.header}>
                <span className={style.headerIzquierda}>
                    <h3>{props.category}</h3>
                    <h1>{props.name}</h1>
                </span>
                <span className={style.headerDerecha}>
                    <button id={style.buttonHome} className={style.button} type="button">{Icons.back}<Link to='/'></Link></button>
                </span>
            </div>

            <div className={style.subHeader}>
                <span className={style.subHeaderIzquierda}>
                    <h3>{props.location}</h3>
                    <p>Cerca del centro</p>
                </span>
                <span className={style.subHeaderDerecha}>
                    <span className={style.calificacion}>
                        {[...new Array(totalStars)].map((arr, index) => {
                            return index < activeStars ? Icons.estrellaLlena : Icons.estrellaVacia;
                        })}
                    </span>
                    <p>{props.calificacion}</p>
                </span>
            </div>

            <div className={style.contenedorImagenes}>
                <span className={style.contenedorImgIzquierda}>
                    <img className={style.imagenIzquierda} src={props.imagen[0]} alt="imagenProductoIzquierda"></img>
                </span>

                <span className={style.contenedorImgDerecha}>
                    <span className={style.subContenedorImgDerecha}>
                        <img className={style.imagenDerecha} src={props.imagen[1]} alt="imagenProductoDerecha"></img>
                        <img className={style.imagenDerecha} src={props.imagen[2]} alt="imagenProductoDerecha"></img>
                    </span>
                    <span className={style.subContenedorImgDerecha}>
                        <img className={style.imagenDerecha} src={props.imagen[3]} alt="imagenProductoDerecha"></img>
                        <img className={style.imagenDerecha} src={props.imagen[4]} alt="imagenProductoDerecha"></img>
                    </span>
                </span>
            </div>

            <div className={style.descriptionContainer}>
                <h2>{props.title}</h2>
                <p>{props.description}</p>
            </div>   

            <div className={style.caracteristicasContainer}>
                <h2>¿Que ofrece este lugar?</h2>
                <span className={style.caracteristicaItms}>
                    {props.caracteristicas.map( (caracteristica) => {
                        return <p>{Icons[caracteristica]} {caracteristica}</p>
                    })}
                </span>
            </div>

            <div className={style.calendarWrap}>
                <span className={style.calendarContainer}>
                    <h2>Fechas disponibles</h2>
                    <DateRange 
                        onChange={item => setRange([item.selection])}
                        editableDateInputs={false}
                        moveRangeOnFirstSelection={false}
                        ranges={range}
                        months={window.innerWidth > 767 ? 2 : 1}
                        direction='horizontal'
                        className={style.calendarElement}
                    />
                </span>
                <span className={style.iniciarReservaContainer}>
                    <h3>Agrega tus fechas de viaje para obtener precios exactos</h3>
                    <button className={style.botonBuscar}>Iniciar reserva</button>
                </span>
            </div>

            <div className={style.politicasAllContainer}>
                <h2>¿Que ofrece este lugar?</h2>
                <span className={style.politicasContainer}>
                    <span className={style.politica}>
                        <h4>Normas de la casa</h4>
                        {props.normasDeLaCasa.map( (value) => {
                            return <p>{value}</p>
                        })}
                    </span>

                    <span className={style.politica}>
                        <h4>Salud y seguridad</h4>
                        {props.saludSeguridad.map( (value) => {
                            return <p>{value}</p>
                        })}
                    </span>

                    <span className={style.politica}>
                        <h4>Politica de cancelacion</h4>
                        {props.politicaDeCancelacion.map( (value) => {
                            return <p>{value}</p>
                        })}
                    </span>

                </span>
            </div>
        </div>
        </>
    )
}