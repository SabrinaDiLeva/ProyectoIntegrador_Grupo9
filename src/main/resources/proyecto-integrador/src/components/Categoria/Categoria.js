import style from './Categoria.module.css'

export default function Categoria(props){
    return (
        <>
            <span className={style.tarjeta}>
                <img className={style.images} src={props.imagen} alt={props.nombre}/>
                <p className={style.nombre}> {props.nombre} </p>
                <small className={style.caption}> {props.caption} </small>
            </span>
        </>
    )
}



