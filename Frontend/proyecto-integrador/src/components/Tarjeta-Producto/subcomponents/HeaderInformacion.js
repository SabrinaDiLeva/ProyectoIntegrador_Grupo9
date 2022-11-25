import style from "./headerInformacion.module.css"
import Estrellas from "./CalificacionEstrellas"

export default function HeaderInformacion(props){
    const totalStars = 5;
    const activeStars = (props.calificacion * totalStars) / 10;

    return (
            <div className={style.subHeader}>
                <span className={style.subHeaderIzquierda}>
                    <h3>{props.location}</h3>
                    <p>Cerca del centro</p>
                </span>
                <span className={style.subHeaderDerecha}>
                    <Estrellas activeStars={activeStars} totalStars={totalStars} />
                    <p>{activeStars.toFixed(0)}</p>
                </span>
            </div>
    )
}