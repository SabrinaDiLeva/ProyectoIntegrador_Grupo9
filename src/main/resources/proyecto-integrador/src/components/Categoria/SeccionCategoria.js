import Categoria from "./Categoria"
import data from "./data.json"

export default function SeccionCategoria() {
    const categorias = data

    return (
        <>
        <h2> Categorias </h2>
        <p> Parrafo que piden que agregue </p>
        {categorias.sort((a, b) => 0.5 - Math.random()).map( (hotel,index) => {
           if (index < 4)
             return <Categoria key={hotel.key} imagen={hotel.imagen} nombre={hotel.nombre} caption={hotel.caption}/>
        } 
        )}
        </>
    )
}