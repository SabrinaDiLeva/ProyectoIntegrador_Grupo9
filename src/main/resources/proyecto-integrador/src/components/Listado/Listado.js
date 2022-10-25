import Card from "./Card"
import data from "./data.json"

export default function Listado(){
    const productos = data

    return (
        <>
        { productos.map( (producto) => {
            return <Card key={producto.key}/>
        })}
        </>
    )
}