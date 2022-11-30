<<<<<<< HEAD
import React, { useState } from 'react';
import style from "./tarjetaProducto.module.css";
import Titulo from "./subcomponents/Titulo"
import Politicas from "./subcomponents/Politicas"
import Calendario from "../Reserva/bloques/Calendario"
import "react-responsive-carousel/lib/styles/carousel.min.css"; // requires a loader
import Carrousel from "./Carrousel";
import { useForm } from "../../hooks/useFormReserva"
import { MdClose } from "react-icons/md"
import HeaderInformacion from './subcomponents/HeaderInformacion';
import Caracteristicas from './subcomponents/Caracteristicas';
import Galeria from './subcomponents/Galeria';
import Boton from "../Botones/BotonLinkTo";

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
                        <div className={style.title}>
                            <h2>Fechas disponibles</h2>
                        </div>
                        <div className={style.containerCalendarReserva}>
                            <div className={style.calendarContainer}>
                                <Calendario formValues={form} handleChange={handleChangeManual} />
                            </div>
                            <div className={style.iniciarReservaContainer}>
                                <div className={style.title}>
                                    <h3>Agrega tus fechas de viaje para obtener precios exactos</h3>
                                </div>

                                <div className={style.BotonContainer}>
                                    <Boton to={`/reserva/producto/${props.id}`} text={"Iniciar reserva"} />
                                </div>
                            </div>
                        </div>
                    </div>

                    <Politicas normasDeLaCasa={props.normasDeLaCasa} saludSeguridad={props.saludSeguridad} politicaDeCancelacion={props.politicaDeCancelacion} />

                </div>
            </div>
=======
import style from "./tarjetaProducto.module.css";
import { Link } from "react-router-dom";
import { DateRange } from 'react-date-range';
import { Icons } from '../ui/icons';
import { Carousel } from 'react-responsive-carousel';
import "react-responsive-carousel/lib/styles/carousel.min.css"; // requires a loader


export default function TarjetaProducto(props) {
    const totalStars = 10;
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
                    <button id={style.buttonHome} className={style.button} type="button"><Link className={style.button} to='/'>{Icons.back}</Link></button>
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
                <button className={style.contenedorImagenesAll} onClick>
                    <span className={style.contenedorImgIzquierda}>
                        <img className={style.imagenIzquierda} src={props.imagen[0].url} alt="imagenProductoIzquierda"></img>
                    </span>

                    <span className={style.contenedorImgDerecha}>
                        <span className={style.subContenedorImgDerecha}>
                            {props.imagen.map( (img, index) => {
                                return index !== 0 ? <img className={style.imagenDerecha} src={img.url} alt="imagenProductoDerecha"></img> : ''
                            })}
                        </span>
                    </span>
                </button>   
            </div>

            <Carousel
                autoPlay
                infiniteLoop
                showArrows={window.innerWidth < 992 ? false : true}
                showThumbs={window.innerWidth < 992 ? false : true}
                showIndicators={false}
                className={style.carrousel}
            >
                {props.imagen.map( (img, index) => {
                    return <>
                        <div className={style.carrouselContainer}>
                            <img className={style.imagenDerecha} src={img} alt="imagenProductoDerecha"></img>
                        </div>
                    </> 
                })}

            </Carousel>
            
            <div className={style.descriptionContainer}>
                <h2>{props.title}</h2>
                <p>{props.description}</p>
            </div>   

            <div className={style.caracteristicasContainer}>
                <h2>¿Que ofrece este lugar?</h2>
                <span className={style.caracteristicaItms}>
                    {props.caracteristicas.map( (caracteristica) => {
                        return <p>{Icons[caracteristica.nombre]} {caracteristica.nombre}</p>
                    })}
                </span>
            </div>

            <div className={style.calendarWrap}>
                <span className={style.calendarContainer}>
                    <h2>Fechas disponibles</h2>
                    <DateRange 
                        // onChange={item => setRange([item.selection])}
                        editableDateInputs={false}
                        moveRangeOnFirstSelection={false}
                        // ranges={range}
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
>>>>>>> daa76d218e2402f4e2ed7e8a758ce90f18001634
        </>
    )
}