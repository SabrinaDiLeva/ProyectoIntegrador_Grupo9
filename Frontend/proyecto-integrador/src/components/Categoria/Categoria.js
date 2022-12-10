import style from './Categoria.module.css'
import Imagen from "../ImagenWrapper/Imagen"

export default function Categoria(props){
    return (
        <>
            <span className={style.tarjeta}>
                <Imagen className={style.images} src={props.imagen} alt={props.nombre}/>
                <p className={style.nombre}> {props.titulo} </p>
                <p className={style.caption}> {props.caption} </p>
            </span>
        </>
    )
}