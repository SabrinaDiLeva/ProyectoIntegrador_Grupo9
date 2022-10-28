import React from "react";
import style from "./login.module.css";


export default function Login() {
    return(
        <>
        <div className={style.container}>
            <form className={style.formulario}>
                <h1 className={style.titulo}>Iniciar sesión</h1>
                
                <span className={style.labelContainer}>
                    <label className={style.label}>Correo electronico</label>
                    <input id={style.input} className={style.mail} type="text"></input>
                    <label className={style.label}>Contraseña</label>
                    <input id={style.input} className={style.password} type="password"></input>
                </span>
                
                <span className={style.botonContainer}>
                    <button type="submit" className={style.boton}>Ingresar</button>
                </span>
            </form>
            <span className={style.registrarse}>¿Aún no tienes cuenta? <a className={style.link} href="/">Registrate</a></span>
        </div>
        </>
    )
}