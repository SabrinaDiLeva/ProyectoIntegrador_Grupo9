import Categoria from "./Categoria"
import data from "./data.json"
import style from './Categoria.module.css'


export default function SeccionCategoria() {
    const categorias = data

    return (
        <>
            <h2>Categorias</h2>
            <p>Busca tu tipo de Alojamiento</p>
            <div className={style.tarjetaContainer}>
                {categorias.map( (hotel,index) => {
                    return <Categoria key={hotel.key} imagen={hotel.imagen} nombre={hotel.nombre} caption={hotel.caption}/>
                })
                }
            </div>
        </>
    )
}