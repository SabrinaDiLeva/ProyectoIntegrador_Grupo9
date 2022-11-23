import style from "./reservaExito.module.css";
import { Icons } from '../ui/icons';

export default function ReservaExito() {
    return (
        <div className={style.container}>
            <div className={style.tarjetaExito}>
                <span className={style.icon}> {Icons["Ok"]} </span>
                <span className={style.thanks}> ¡Muchas gracias!</span>
                <span className={style.confirm}> Su reserva se ha realizado con éxito</span>
                <button className={style.button}> Ok </button>
            </div>
        </div>
    )
}