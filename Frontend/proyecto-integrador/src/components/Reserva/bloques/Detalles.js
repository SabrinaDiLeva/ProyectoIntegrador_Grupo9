import style from "./detalle.module.css"

export default function Detalles(props) {
    return (
        <>
            <div className={style.container}>
                <div className={style.title}>
                    <h2> Detalle de reserva </h2>
                </div>
                <div className={style.product}>
                    <img src={props.image} alt="Imagen principal del producto" />
                    <div className={style.details}>
                        <div className={style.product_details}>
                            <div className={style.category}>
                                <span>{props.category.toUpperCase()}</span>
                            </div>
                            <div className={style.name}>
                                <h2>{props.title}</h2>
                            </div>
                            <div className={style.location}>
                                <span>{props.city}</span>
                            </div>
                        </div>
                        <div className={style.dates}>
                            <div className={style.checkIn}>
                                <p>Check in: </p><p>27/12/2022</p>
                            </div>
                            <hr />
                            {/* Checkin: Fecha de entrada */}
                            <div className={style.checkOut}>
                                <span>Check out: </span><span>07/01/2023</span>
                            </div>
                            <hr />
                            {/* Checkout: Fecha de salida*/}
                        </div>
                        <button className={style.button}> Confirmar reserva </button>
                        {/* Boton de confirmación de reserva */}
                    </div>
                </div>
            </div>
        </>
    )
}
/*
categroy
image
title
city
*/