import style from "./caracteristicas.module.css"
import Subtitle from "./Subtitle"
import { Icons } from "../../ui/icons"

export default function Caracteristicas(props) {
    return (
        <div className={style.caracteristicas}>
            <Subtitle subtitle={"¿Que ofrece este lugar?"}/>

            <span className={style.caracteristicaItems}>
                {props.caracteristicas.map((caracteristica) => {
                    return <p>{Icons[caracteristica.nombre]} {caracteristica.nombre}</p>
                })}
            </span>
        </div>
    )
}