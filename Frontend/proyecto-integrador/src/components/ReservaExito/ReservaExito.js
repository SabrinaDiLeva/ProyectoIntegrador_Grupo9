import style from "./reservaExito.module.css";
import ExitoContainer from "./subcomponents/ExitoContainer";

export default function ReservaExito() {
    return (
        <div className={style.container}>
            <ExitoContainer thanks={'¡Muchas gracias!'} confirm={'Su reserva se ha realizado con éxito'} ok={'Ok'} />
        </div>
    )
}