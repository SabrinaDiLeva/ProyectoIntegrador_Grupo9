import style from "./calificacionEstrellas.module.css"
import {Icons} from "../../ui/icons"

export default function CalificacionEstrellas(props) {

    return (
                    <span className={style.calificacion}>
                        {[...new Array(props.totalStars)].map((arr, index) => {
                            return index < props.activeStars ? Icons.estrellaLlena : Icons.estrellaVacia;
                        })}
                    </span>
    )
}