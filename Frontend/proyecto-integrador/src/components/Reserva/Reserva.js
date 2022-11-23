import style from "./reserva.module.css"
//Tarjeta detalle
import Detalle from "./bloques/Detalles.js"
//Formulario para llenar de datos
import DatosPersonales from "./bloques/DatosPersonales"
// Header secundario con titulo y botón de retorno
import Titulo from "../Tarjeta-Producto/subcomponents/Titulo"
//BloquePoliticas
import Politicas from "../Tarjeta-Producto/subcomponents/Politicas"
//Calendario
import Calendario from "./bloques/Calendario"
//Form de Reserva
import { useForm } from "../../hooks/useFormReserva"

import { useEffect, useState } from "react"
import { useParams } from "react-router-dom";
import { getProducto } from "../../service/productoApi"
import { getImagenesPorProducto } from "../../service/imagenApi"

export default function Reserva() {

    const producto = {
        categoria: "Hotel",
        titulo: "Hermanos Hoyos",
        ciudad: "Buenos Aires, La Matanza",
        normas: ["No gritar fuerte"],
        cancelacion: ["No hay forma de cancelarlo"],
        seguridad: ["WiFi"],
    }

    const imagenes = [
        "https://images.unsplash.com/photo-1618773928121-c32242e63f39?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80"
    ]

    {/*
    let { id } = useParams();
    

    const [producto, setProducto] = useState({})
    const [imagenes, setImagenes] = useState([])
    //Obtener info del sessionStorage?
    const [usuario, setUsuario] = useState([])

    useEffect( () => {
        getProducto(id).then( (data) => {
            console.log(data);
            setProducto(data);
        })
    }, [id])
    
    
    useEffect( () => {
        getImagenesPorProducto(id).then( (data) => {
            console.log(data);
            setImagenes(data);
        })
    }, [id])

*/}
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
    
        if(!regexName.test(form.city.trim())){
            errors.city = "Ingrese caracteres válidos"
        }

        //Validar que la fechas estén disponibles
        //Básicamente que se encuentren en el atributo del Producto
    };
    {/* Se debe recolectar la información y mandarsela al padre, dueño del form. */}
    {/* Uso de Hook UseForm
    1. Crea los valores iniciales
    2. Crea la validación de campos
    3. Importa
       - form: Objeto que posee los campos del formulario a llenar
       - errors: concatena los errores que existen en el login
       - handleChange: Al cambiar el campo, useForm actualiza los campos del form (dependiendo de quien fue el que cambio)
       - handleSubmit: Al enviar el formulario, valida que el usuario y contraseña coincidan. Si coincide, guarda en sessionStorage y redirije al home
    4. form. utiliza para darle valores al form.
    5. errors. utiliza para mostrar los errores
*/}

    const {form, handleChange, handleChangeManual, handleSubmit} = useForm(initialForm, validationForm);
    return (
        <>
            <div className={style.container}>
                <Titulo category={producto.categoria} name={producto.titulo} />
                <div className={style.body}>
                    {/* Bloque con el formulario y el calendario de reserva*/}
                    <div className={style.form}>
                        <h1 className={style.titulo}>Completá tus datos</h1>
                        <div className={style.form_data}>
                            {/*Formulario con los datos*/}
                            <form className={style.formulario} onSubmit={handleSubmit}>
                                <DatosPersonales formValues={form} handleChange={handleChange}/>
                            </form>
                        </div>
                        <h1 className={style.titulo}>Seleccioná tu fecha de reserva</h1>
                        <Calendario formValues={form} handleChange={handleChangeManual}/>
                        {/*
                            Hora de llegada
                        <h1 className={style.titulo}>Tu horario de llegada</h1>
                        <div className={style.arrival_time}>
                        </div>
                        */}
                    </div>
                    <div className={style.details}>
                        <Detalle category={producto.categoria} image={imagenes[0]} title={producto.titulo} city={producto.ciudad} checkInDate={form.checkInDate} checkOutDate={form.checkOutDate} />
                    </div>
                </div>
                <Politicas normasDeLaCasa={producto.normas} saludSeguridad={producto.seguridad} politicaDeCancelacion={producto.cancelacion} />
            </div>
        </>
    )
}