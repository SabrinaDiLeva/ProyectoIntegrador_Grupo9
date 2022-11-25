import { useEffect, useState } from "react"
import { useParams } from "react-router-dom";
import { getProducto } from "../../service/productoApi"
import { getImagenesPorProducto } from "../../service/imagenApi"
import Reserva from "./Reserva";

export default function ReservaWrapper() {

    let { id } = useParams();
    const [producto, setProducto] = useState({})
    const [imagenes, setImagenes] = useState([])

    useEffect(() => {
        console.log("HOLAAAAAAAAAAA")
        getProducto(id).then((data) => {
            console.log(data);
            setProducto(data);
        })
    }, [id])

    useEffect(() => {
        console.log("HOLAAAAAAAAAAA")
        getImagenesPorProducto(id).then((data) => {
            console.log(data);
            setImagenes(data);
        })
    }, [id])

    return (
        <>
           { (imagenes.length !== 0 && producto !== undefined)? <Reserva categoria={producto.categoria.titulo} ciudad={producto.ciudad.provincia} titulo={producto.titulo} seguridad={producto.seguridad} cancelacion={producto.cancelacion} normas={producto.normas} imagenes={imagenes} /> : <></>}
        </>
    )
}