import style from "./datosPersonales.module.css"
import { useState } from "react";
import { set } from "date-fns";

export default function DatosPersonales(props) {
    return (
        <span className={style.labelContainer}>
            <div>
                <label className={style.label}>Nombre</label>
                <input id={style.name} className={style.input} type="text" name="name" placeholder="Nombre" value={props.formValues.name} disabled></input>
            </div>

            <div>
                <label className={style.label}>Apellido</label>
                <input id={style.lastname} className={style.input} type="text" name="lastname" placeholder="Apellido" value={props.formValues.lastname} disabled></input>
            </div>

            <div>
                <label className={style.label}>Correo electronico</label>
                <input id={style.email} className={style.input} type="email" name="email" placeholder="Email" value={props.formValues.email} disabled></input>
                
            </div>

            <div>
                <label className={style.label}>Ciudad</label>
                <input id={style.city} className={style.input} type="text" name="city" placeholder="Ciudad" value={props.formValues.city} onChange={props.handleChange} ></input>
            </div>
        </span>
    )
}