import style from './Card.module.css'



export default function Card(props) {

    return (
    <>
    <span className={style.tarjeta}>
        <div className={style.infoContainerImagen}>
            <img className={style.cardImage} src={props.imagen}  alt="producto"></img>
        </div>
        <div className={style.infoContainerDetalle}>
            <span className={style.detalleContainer}>
                <p className={style.cardCategoria}>{props.category}</p>
                <h1 className={style.cardNombre}>{props.title}</h1>
                <p className={style.cardLocation}>{props.location}</p>
                <p className={style.cardDescripcion}>{props.description}</p>
                <span className={style.verMasContainer}>
                    <a className={style.verMas} href='/'>Ver Mas</a>
                </span>
            </span>
            <button className={style.cardBoton}>Ver detalle</button>
        </div>
    </span>
    </>
    )
}