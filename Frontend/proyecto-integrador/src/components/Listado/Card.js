import style from './Card.module.css'
<<<<<<< HEAD
import { Icons } from '../ui/icons';
import Boton from '../Botones/BotonLinkTo';
import Estrellas from "../Tarjeta-Producto/subcomponents/CalificacionEstrellas"
=======
import { Link } from "react-router-dom";
>>>>>>> daa76d218e2402f4e2ed7e8a758ce90f18001634

export default function Card(props) {

    return (
<<<<<<< HEAD
        <>
            <span className={style.tarjeta}>
                <div className={style.infoContainerImagen}>
                    <img className={style.cardImage} src={props.imagen} alt="producto"></img>
                </div>
                <div className={style.infoContainerDetalle}>
                    <div className={style.detalleContainer}>
                        <div className={style.categoria}>
                            <p className={style.cardCategoria}>{props.category.toUpperCase()}</p>
                            <Estrellas totalStars={5} activeStars={props.calificacion * 5 / 10}/>
                        </div>
                        <h1 className={style.cardNombre}>{props.title}</h1>
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
=======
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
            <button className={style.cardBoton}><Link className={style.button} to={`/producto/${props.id}`}>Ver detalle</Link></button>
        </div>
    </span>
    </>
>>>>>>> daa76d218e2402f4e2ed7e8a758ce90f18001634
    )
}