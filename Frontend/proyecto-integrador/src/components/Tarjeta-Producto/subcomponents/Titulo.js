import style from "./titulo.module.css";
import { Icons } from '../../ui/icons';
import { Link } from "react-router-dom";

export default function Titulo(props) {
    return (
        <div className={style.container}>
            <div className={style.header}>
                <span className={style.headerIzquierda}>
                    <h3>{props.category}</h3>
                    <h1>{props.name}</h1>
                </span>
                <span className={style.headerDerecha}>
                    <button id={style.buttonHome} className={style.button} type="button"><Link className={style.button} to='/'>{Icons.back}</Link></button>
                </span>
            </div>
        </div>
    )
}
/*
category
name
*/