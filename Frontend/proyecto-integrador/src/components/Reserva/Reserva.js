import style from "./reserva.module.css"
import Detalle from "./bloques/Detalles.js"
import DatosPersonales from "./bloques/DatosPersonales"
import Titulo from "../Tarjeta-Producto/subcomponents/Titulo"
import Politicas from "../Tarjeta-Producto/subcomponents/Politicas"
import Calendario from "./bloques/Calendario"
import { useForm } from "../../hooks/useFormReserva"

import { useState } from "react"
import { useParams } from "react-router-dom";
import { getImagenesPorProducto} from "../../service/imagenApi"

export default function Reserva(props) {
    let id = useParams();
    //Obtener info del sessionStorage?
    const [usuario, setUsuario] = useState([])


    const initialForm = {
        //¿Poner info del SessionStorage o de la API?
        name: "Nombre",
        lastname: "Apellido",
        email: "Email",
        city: "",
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
        //Básicamente que se encuentren en el atributo del props
    };

    const { form, handleChange, handleChangeManual, handleSubmit } = useForm(initialForm, validationForm);
    return (
        <>
            <div className={style.container}>
                <Titulo category={props.categoria} name={props.titulo} />
                <div className={style.body}>
                    {/* Bloque con el formulario y el calendario de reserva*/}
                    <div className={style.form}>
                        <h1 className={style.titulo}>Completá tus datos</h1>
                        <div className={style.form_data}>
                            {/*Formulario con los datos*/}
                            <form className={style.formulario} onSubmit={handleSubmit}>
                                <DatosPersonales formValues={form} handleChange={handleChange} />
                            </form>
                        </div>
                        <h1 className={style.titulo}>Seleccioná tu fecha de reserva</h1>
                        <Calendario formValues={form} handleChange={handleChangeManual} />
                    </div>
                    <div className={style.details}>
                        <Detalle category={props.categoria} image={props.imagenes[0].url} title={props.titulo} city={props.ciudad} checkInDate={form.checkInDate} checkOutDate={form.checkOutDate} />
                    </div>
                </div>
                <div className={style.politicas}>
                    <Politicas normasDeLaCasa={props.normas} saludSeguridad={props.seguridad} politicaDeCancelacion={props.cancelacion} />
                </div>
            </div>
        </>
    )
}