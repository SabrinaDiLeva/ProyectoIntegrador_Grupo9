import Categoria from "./Categoria"
import data from "./data.json"
import style from './Categoria.module.css'


export default function SeccionCategoria() {
    const categorias = data

    return (
        <>
        <div className={style.body}>
            <h1 className={style.titulo}>Busca tu tipo de Alojamiento</h1>
            <div className={style.tarjetaContainer}>
                {categorias.map( (hotel,index) => {
                    return <Categoria key={hotel.key} imagen={hotel.imagen} nombre={hotel.nombre} caption={hotel.caption}/>
                })
                }
            </div>
        </div>
        </>
    )
}