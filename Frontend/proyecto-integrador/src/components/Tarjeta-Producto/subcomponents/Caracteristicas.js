import style from "./caracteristicas.module.css"
import { Icons } from "../../ui/icons"

export default function Caracteristicas(props) {
    return (
        <div className={style.caracteristicas}>
            <h2>¿Que ofrece este lugar?</h2>
            <span className={style.caracteristicaItems}>
                {props.caracteristicas.map((caracteristica) => {
                    return <p>{Icons[caracteristica.nombre]} {caracteristica.nombre}</p>
                })}
            </span>
        </div>
    )
}