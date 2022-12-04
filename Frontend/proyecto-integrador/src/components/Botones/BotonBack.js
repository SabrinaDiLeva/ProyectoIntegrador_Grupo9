import { Link } from "react-router-dom"
import style from "./botonBack.module.css"
import { Icons } from "../ui/icons"

export default function BotonBack(props) {
    return (
        <button id={style.buttonHome} className={style.button} type="button"><Link className={style.button} to={props.to}>{Icons.back}</Link></button>
    )
}