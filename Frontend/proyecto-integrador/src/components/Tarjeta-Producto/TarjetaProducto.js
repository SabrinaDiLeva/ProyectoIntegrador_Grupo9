import React, { useState } from 'react';
import style from "./tarjetaProducto.module.css";
import Titulo from "./subcomponents/Titulo"
import Politicas from "./subcomponents/Politicas"
import Calendario from "../Reserva/bloques/Calendario"
import { Link } from "react-router-dom";
import "react-responsive-carousel/lib/styles/carousel.min.css"; // requires a loader
import Carrousel from "./Carrousel";
import { useForm } from "../../hooks/useFormReserva"
import { MdClose } from "react-icons/md"
import HeaderInformacion from './subcomponents/HeaderInformacion';
import Caracteristicas from './subcomponents/Caracteristicas';
import Galeria from './subcomponents/Galeria';


export default function TarjetaProducto(props) {

    const [carrouselOpen, setcarrouselOpen] = useState(false)

    const handleToggle = () => {
        setcarrouselOpen(!carrouselOpen)
    }

    const initialForm = {
        checkInDate: "DD/MM/YYYY",
        checkOutDate: "DD/MM/YYYY"
    }

    const validationForm = (form) => {
        let errors = {};
        //Cambiar Regex para ciudades
        let regexName = /^[A-Za-zÑñÁáÉéÍíÓóÚúÜü\s]+$/;

        if (!regexName.test(form.city.trim())) {
            errors.city = "Ingrese caracteres válidos"
        }

        //Validar que la fechas estén disponibles
        //Básicamente que se encuentren en el atributo del Producto
    };
    const { form, handleChange, handleChangeManual, handleSubmit } = useForm(initialForm, validationForm);
    return (
        <>
            <div className={style.container}>
                <Titulo category={props.category} name={props.name} />
                <HeaderInformacion location={props.location} calificacion={props.calificacion} />
                <div className={style.subContainer}>
                    <Galeria imagenes={props.imagen} handleToggle={handleToggle} />

                    {carrouselOpen &&
                        <>
                            <div className={style.carrouselContainer}>
                                <button className={style.carrouselButton} onClick={handleToggle}>
                                    <MdClose className={style.menuCerrado} />
                                </button>
                                <Carrousel imagenes={props.imagen} />
                            </div>
                        </>
                    }

                    <div className={style.descriptionContainer}>
                        <h2>{props.title}</h2>
                        <p>{props.description}</p>
                    </div>

                    <Caracteristicas caracteristicas={props.caracteristicas} />

                    <div className={style.calendarWrap}>
                        <span className={style.calendarContainer}>
                            <h2>Fechas disponibles</h2>
                            <Calendario formValues={form} handleChange={handleChangeManual} />
                        </span>
                        <span className={style.iniciarReservaContainer}>
                            <h3>Agrega tus fechas de viaje para obtener precios exactos</h3>
                            <button className={style.botonBuscar} type="button"><Link to='/reserva/producto/{props.id}'>Iniciar reserva</Link></button>
                        </span>
                    </div>

                    <Politicas normasDeLaCasa={props.normasDeLaCasa} saludSeguridad={props.saludSeguridad} politicaDeCancelacion={props.politicaDeCancelacion} />

                </div>
            </div>
        </>
    )
}