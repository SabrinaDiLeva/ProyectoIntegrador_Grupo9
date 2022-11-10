import Card from "./TarjetaProducto"
import { useEffect, useState } from "react"
import { getProducto } from "../../service/productoApi"

export default function Producto(id){
    const [producto, setProducto] = useState({})

    useEffect( () => {
        getProducto(id).then( (data) => {
            console.log(data);
            setProducto(data);
        })
    }, [id])

    return (
        <>
            <Card key={producto.id} imagen={producto.imagen} category={producto.categoria} name={producto.nombre} title={producto.titulo} location={producto.ciudad} description={producto.descripcion} calificacion={producto.calificacion} caracteristicas={producto.caracteristica} politicas={producto.politicas} normasDeLaCasa = {producto.normas} saludSeguridad = {producto.seguridad} politicaDeCancelacion = {producto.cancelacion} />
        </>
    )
}