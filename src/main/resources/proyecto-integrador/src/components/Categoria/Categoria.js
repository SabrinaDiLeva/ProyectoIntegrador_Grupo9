import style from './Categoria.module.css'

export default function Categoria(props){
    return (
        <>
            <img className={style.images} src={props.imagen} alt={props.nombre}/>
            <p className={style.caption}> {props.caption} </p>
        </>
    )
}