import Card from "./TarjetaProducto"
import data from "./data.json"

export default function Producto(id){
    const productos = data[1]

    return (
        <>
            <Card key={productos.key} imagen={productos.imagen} category={productos.category} name={productos.name} title={productos.title} location={productos.location} description={productos.description} calificacion={productos.calificacion} caracteristicas={productos.caracteristicas} politicas={productos.politicas} normasDeLaCasa = {productos.normasDeLaCasa} saludSeguridad = {productos.saludSeguridad} politicaDeCancelacion = {productos.politicaDeCancelacion} />
        </>
    )
}