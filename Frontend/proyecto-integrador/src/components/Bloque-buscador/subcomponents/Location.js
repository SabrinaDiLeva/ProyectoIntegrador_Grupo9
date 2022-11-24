import style from "./location.module.css"
import { Icons } from "../../ui/icons"

export default function Location(props) {
    return (
        <a href='/' className={style.locations}>
            <span> {Icons.location} </span>
            <span className={style.liContainer}>
                <li className={style.opcionProvincia}>{props.provincia.nombre}</li>
                <li className={style.opcionPais}>{props.provincia.pais}</li>
            </span>
        </a>
    )
}