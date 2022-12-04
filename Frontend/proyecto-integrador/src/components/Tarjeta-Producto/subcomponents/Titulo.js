import style from "./titulo.module.css";
import BotonBack from "../../Botones/BotonBack"

export default function Titulo(props) {
    return (
        <div className={style.container}>
            <div className={style.header}>
                <span className={style.headerIzquierda}>
                    <h3>{props.category}</h3>
                    <h1>{props.name}</h1>
                </span>
                <span className={style.headerDerecha}>
                    <BotonBack to={'/'}/>
                </span>
            </div>
        </div>
    )
}
/*
category
name
*/