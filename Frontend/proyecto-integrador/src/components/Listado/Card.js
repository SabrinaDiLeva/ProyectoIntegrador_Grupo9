import style from './Card.module.css'
import { Icons } from '../ui/icons';
import Boton from '../Botones/BotonLinkTo';
import Estrellas from "../Tarjeta-Producto/subcomponents/CalificacionEstrellas"
import Imagen from "../ImagenWrapper/Imagen"

export default function Card(props) {

    return (
        <>
            <span className={style.tarjeta}>
                <div className={style.infoContainerImagen}>
                    <Imagen className={style.cardImage} src={props.imagen} alt="producto"/>
                </div>
                <div className={style.infoContainerDetalle}>
                    <div className={style.detalleContainer}>
                        <div className={style.categoria}>
                            <p className={style.cardCategoria}>{props.category.toUpperCase()}</p>
                            <Estrellas totalStars={5} activeStars={props.calificacion * 5 / 10}/>
                        </div>
                        <h1 className={style.cardNombre}>{props.name}</h1>
                        <p className={style.cardLocation}>{Icons.location} {props.location}</p>
                        <span className={style.textoContainer}>
                            <span className={style.cardDescripcion}>{props.description}</span>
                            <a className={style.verMas} href={`/producto/${props.id}`}>ver más</a>
                        </span>
                    </div>
                    <div className={style.BotonContainer}>
                        <Boton to={`/producto/${props.id}`} text={"Ver detalle"} />
                    </div>
                </div>
        </span>
        </>
    )
}