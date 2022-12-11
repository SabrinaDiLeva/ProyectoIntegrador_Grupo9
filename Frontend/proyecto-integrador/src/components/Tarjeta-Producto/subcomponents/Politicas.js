import style from "./politicas.module.css"
import Subtitle from "./Subtitle"

export default function Politicas(props) {
    return (
        <div className={style.politicasAllContainer}>
            <Subtitle subtitle={"Que tenés que saber"}/>
            <span className={style.politicasContainer}>
                <span className={style.politica}>
                    <h4>Normas de la casa</h4>
                    {props.normasDeLaCasa.map((value) => {
                        return <p>{value.norma}</p>
                    })}
                </span>

                <span className={style.politica}>
                    <h4>Salud y seguridad</h4>
                    {props.saludSeguridad.map((value) => {
                        return <p>{value.politica}</p>
                    })}
                </span>

                <span className={style.politica}>
                    <h4>Politica de cancelacion</h4>
                    {props.politicaDeCancelacion.map((value) => {
                        return <p>{value.politica}</p>
                    })}
                </span>

            </span>
        </div>
    )
}

/*
normasDeLaCasa
saludSeguridad
politicasDeCancelacion
*/