import style from "./reserva.module.css"
import Detalle from "./bloques/Detalles.js"
import Titulo from "../Tarjeta-Producto/subcomponents/Titulo"
import Politicas from "../Tarjeta-Producto/subcomponents/Politicas"
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
                            <form className={style.formulario}>

                                <span className={style.labelContainer}>
                                    <div>
                                    <label className={style.label}>Nombre</label>
                                    <input id={style.password} className={style.input} type="text" name="nombre" placeholder="nombre"></input>
                                    </div>

                                    <div>
                                    <label className={style.label}>Apellido</label>
                                    <input id={style.password} className={style.input} type="text" name="apellido" placeholder="apellido"></input>
                                    </div>

                                    <div>
                                    <label className={style.label}>Correo electronico</label>
                                    <input id={style.mail} className={style.input} type="email" name="email" placeholder="correo"></input>
                                    </div>

                                    <div>
                                    <label className={style.label}>Ciudad</label>
                                    <input id={style.password} className={style.input} type="text" name="ciudad" placeholder="ciudad"></input>
                                    </div>
                                </span>

                            </form>
                        </div>
                        <h1 className={style.titulo}>Seleccioná tu fecha de reserva</h1>
                        <div className={style.calendar}>
                            {/*Calendario de reservas*/}
                        </div>
                        <h1 className={style.titulo}>Tu horario de llegada</h1>
                        <div className={style.arrival_time}>
                            {/*Hora de llegada*/}
                        </div>
                    </div>
                    <div className={style.details}>
                        <Detalle category={producto.categoria} image={imagenes[0]} title={producto.titulo} city={producto.ciudad} />
                    </div>
                </div>
                <Politicas normasDeLaCasa={producto.normas} saludSeguridad={producto.seguridad} politicaDeCancelacion={producto.cancelacion} />
            </div>
        </>
    )
}