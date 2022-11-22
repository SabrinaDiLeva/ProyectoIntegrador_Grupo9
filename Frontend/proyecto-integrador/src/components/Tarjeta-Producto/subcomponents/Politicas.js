import style from "./politicas.module.css"

export default function Politicas(props) {
    return (
            <div className={style.politicasAllContainer}>
            <h2>¿Que ofrece este lugar?</h2>
            <span className={style.politicasContainer}>
                <span className={style.politica}>
                    <h4>Normas de la casa</h4>
                    {props.normasDeLaCasa.map( (value) => {
                        return <p>{value}</p>
                    })}
                </span>

                <span className={style.politica}>
                    <h4>Salud y seguridad</h4>
                    {props.saludSeguridad.map( (value) => {
                        return <p>{value}</p>
                    })}
                </span>

                <span className={style.politica}>
                    <h4>Politica de cancelacion</h4>
                    {props.politicaDeCancelacion.map( (value) => {
                        return <p>{value}</p>
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