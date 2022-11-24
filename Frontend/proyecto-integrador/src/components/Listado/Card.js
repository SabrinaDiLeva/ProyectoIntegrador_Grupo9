import style from './Card.module.css'
import { Icons } from '../ui/icons';
import Boton from '../Botones/BotonLinkTo';

export default function Card(props) {

    return (
    <>
    <span className={style.tarjeta}>
        <div className={style.infoContainerImagen}>
            <img className={style.cardImage} src={props.imagen}  alt="producto"></img>
        </div>
        <div className={style.infoContainerDetalle}>
            <div className={style.detalleContainer}>
                <p className={style.cardCategoria}>{props.category}</p>
                <h1 className={style.cardNombre}>{props.title}</h1>
                <p className={style.cardLocation}>{Icons.location} {props.location}</p>
                <span className={style.textoContainer}>
                <span className={style.cardDescripcion}>{props.description}
                </span>
                    <a className={style.verMas} href={`/producto/${props.id}`}>ver más</a>             
                </span>
            </div>
            <div className={style.BotonContainer}>
                <Boton to={`/producto/${props.id}`} text={"Ver detalle"}/>
            </div>
        </div>
    </span>
    </>
    )
}