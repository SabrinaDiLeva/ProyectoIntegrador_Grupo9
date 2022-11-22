import style from "./datosPersonales.module.css"

export default function DatosPersonales() {
    return (
        <span className={style.labelContainer}>
            <div>
                <label className={style.label}>Nombre</label>
                <input id={style.password} className={style.input} type="text" name="nombre" placeholder="nombre"></input>
            </div>

            <div>
                <label className={style.label}>Apellido</label>
                <input id={style.password} className={style.input} type="text" name="apellido" placeholder="apellido"></input>
            </div>

            <div>
                <label className={style.label}>Correo electronico</label>
                <input id={style.mail} className={style.input} type="email" name="email" placeholder="correo"></input>
            </div>

            <div>
                <label className={style.label}>Ciudad</label>
                <input id={style.password} className={style.input} type="text" name="ciudad" placeholder="ciudad"></input>
            </div>
        </span>
    )
}