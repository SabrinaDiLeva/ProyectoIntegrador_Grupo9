import React, { useEffect, useState } from 'react';
import style from "./tarjetaProducto.module.css";
import Titulo from "./subcomponents/Titulo"
import Politicas from "./subcomponents/Politicas"
import Calendario from "../Reserva/bloques/Calendario"
import "react-responsive-carousel/lib/styles/carousel.min.css"; // requires a loader
import Carrousel from "./Carrousel";
import { useForm } from "../../hooks/useFormReserva"
import HeaderInformacion from './subcomponents/HeaderInformacion';
import Caracteristicas from './subcomponents/Caracteristicas';
import Galeria from './subcomponents/Galeria';
import Boton from "../Botones/BotonLinkTo";

 

export default function TarjetaProducto(props) {

    const [carrouselOpen, setCarrouselOpen] = useState(true)

    const handleToggle = () => {
        setCarrouselOpen(!carrouselOpen)
    }

    const initialForm = {
        checkInDate: "DD/MM/YYYY",
        checkOutDate: "DD/MM/YYYY"
    }

    useEffect( () => {
        function handleResize() {
            setCarrouselOpen(window.innerWidth < 1024 )
        }
        window.addEventListener('resize', handleResize)
    })

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
                    <div className={style.imgContainer}>
                        <div className={style.galeria}>
                            <Galeria  imagenes={props.imagen} handleToggle={handleToggle} />
                        </div>

                        {carrouselOpen && <Carrousel imagenes={props.imagen} handleToggle={handleToggle}/>
                        }
                    </div>

                    <div className={style.descriptionContainer}>
                        <h2>{props.title}</h2>
                        <p>{props.description}</p>
                    </div>

                    <Caracteristicas caracteristicas={props.caracteristicas} />
                    <div className={style.iniciarReservaContainer}>
                        <div className={style.subtitle}>
                            <h3>Agrega tus fechas de viaje para obtener precios exactos</h3>
                        </div>

                        <div className={style.BotonContainer}>
                            <Boton to={sessionStorage.getItem('sessionIniciada') ? `/reserva/producto/${props.id}` : `/iniciar_sesion`} text={"Iniciar reserva"} />
                        </div>
                    </div>

                    <Politicas normasDeLaCasa={props.normasDeLaCasa} saludSeguridad={props.saludSeguridad} politicaDeCancelacion={props.politicaDeCancelacion} />

                </div>
            </div>
        </>
    )
}