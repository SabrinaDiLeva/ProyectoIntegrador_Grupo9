import style from './Categoria.module.css'

export default function Categoria(props){
    return (
        <>
            <span className={style.tarjeta}>
<<<<<<< HEAD
                <img className={style.images} src={props.imagen} alt={props.nombre}/>
                <p className={style.nombre}> {props.titulo} </p>
                <p className={style.caption}> {props.caption} </p>
=======
                <img className={style.images} src={props.imagen.url} alt={props.nombre}/>
                <p className={style.nombre}> {props.titulo} </p>
                <small className={style.caption}> {props.caption} </small>
>>>>>>> daa76d218e2402f4e2ed7e8a758ce90f18001634
            </span>
        </>
    )
}