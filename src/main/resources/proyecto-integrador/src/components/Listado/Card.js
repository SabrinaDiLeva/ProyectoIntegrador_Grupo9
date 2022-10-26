import style from './Card.module.css'



export default function Card(props) {
    return (
    <>
    <div className={style.tarjeta}>
        <span className={style.infoContainerImagen}>
            <img className={style.cardImage} src={props.imagen}  alt="producto"></img>
        </span>
        <span className={style.infoContainerDetalle}>
            <p className={style.cardCategoria}>{props.category}</p>
            <p className={style.cardNombre}>{props.title}</p>
            <p className={style.cardLocation}>{props.location}</p>
            <p className={style.cardDescripcion}>{props.description}</p>
            <button className={style.cardBoton}>Ver detalle</button>
        </span>
    </div>
    </>
    )
}