import style from "./datosPersonales.module.css"
import { useState } from "react";

export default function DatosPersonales() {

    const [name, setName] = useState("User's name");
    const [lastname, setLastname] = useState("User's lastname");
    const [email, setEmail] = useState("User's email");

    return (
        <span className={style.labelContainer}>
            <div>
                <label className={style.label}>Nombre</label>
                <input id={style.password} className={style.input} type="text" name="nombre" placeholder={name} disabled></input>
            </div>

            <div>
                <label className={style.label}>Apellido</label>
                <input id={style.password} className={style.input} type="text" name="apellido" placeholder={lastname} disabled></input>
            </div>

            <div>
                <label className={style.label}>Correo electronico</label>
                <input id={style.mail} className={style.input} type="email" name="email" placeholder={email} disabled></input>
            </div>

            <div>
                <label className={style.label}>Ciudad</label>
                <input id={style.password} className={style.input} type="text" name="ciudad" placeholder="Ciudad"></input>
            </div>
        </span>
    )
}