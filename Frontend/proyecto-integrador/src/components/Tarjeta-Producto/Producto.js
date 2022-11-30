import Card from "./TarjetaProducto"
import { useEffect, useState } from "react"
import { getProducto } from "../../service/productoApi"
import { getImagenesPorProducto } from "../../service/imagenApi" 
import { useParams} from "react-router-dom";

export default function Producto(){
    let { id } = useParams();

    const [producto, setProducto] = useState({})
    const [imagenes, setImagenes] = useState([])

    useEffect( () => {
<<<<<<< HEAD
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

    return (
        <>
            {(imagenes.length !== 0 && producto !== undefined)? <Card key={producto.id} id={producto.id} imagen={imagenes} category={producto.categoria.titulo} name={producto.nombre} title={producto.titulo} location={producto.ciudad.nombre} description={producto.descripcion} calificacion={producto.calificacion} caracteristicas={producto.caracteristica} politicas={producto.politicas} normasDeLaCasa = {producto.normas} saludSeguridad = {producto.seguridad} politicaDeCancelacion = {producto.cancelacion} /> : <></>}
=======
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

    return (
        <>
            {(imagenes.length !== 0 && producto !== undefined)? <Card key={producto.id} imagen={imagenes} category={producto.categoria.titulo} name={producto.nombre} title={producto.titulo} location={producto.ciudad.nombre} description={producto.descripcion} calificacion={producto.calificacion} caracteristicas={producto.caracteristica} politicas={producto.politicas} normasDeLaCasa = {producto.normas.split(';')} saludSeguridad = {producto.seguridad.split(';')} politicaDeCancelacion = {producto.cancelacion.split(';')} /> : <></>}
>>>>>>> daa76d218e2402f4e2ed7e8a758ce90f18001634
        </>
    )
}