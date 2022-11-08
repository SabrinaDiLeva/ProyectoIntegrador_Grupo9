import Card from "./TarjetaProducto"
import data from "./data.json"
import style from './tarjetaProducto.module.css'


export default function Producto(id){
    const productos = data[1]

    return (
        <>
            <Card key={productos.key} imagen={productos.imagen} category={productos.category} name={productos.name} title={productos.title} location={productos.location} description={productos.description} calificacion={productos.calificacion} />
        </>
    )
}