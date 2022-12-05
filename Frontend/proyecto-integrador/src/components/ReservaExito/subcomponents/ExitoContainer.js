import style from "./ExitoContainer.module.css";
import { Icons } from "../../ui/icons";
import { Link } from "react-router-dom";

export default function ExitoContainer(props) {
    return (
            <div className={style.tarjetaExito}>
                <span className={style.icon}> {Icons["Ok"]} </span>
                <span className={style.thanks}> {props.thanks}</span>
                <span className={style.confirm}> {props.confirm}</span>
                <button className={style.button}><Link to='/'>{props.ok}</Link></button>
            </div>
    )
}