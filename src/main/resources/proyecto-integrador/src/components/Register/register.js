import React from "react";
import style from "./register.module.css";


export default function Register() {
    return(
            <div className={style.container}>
                <form  className={style.formulario}>
                    <h1 className={style.titulo}>Crear cuenta</h1>
                    <div className={style.firstContainer}>
                        <span className={style.labelContainer}>
                            <label className={style.label}>Nombre</label>
                            <input type="text" id={style.input} />
                        </span>
                        <span className={style.labelContainer}>
                            <label className={style.label}>Apellido</label>
                            <input type="text" id={style.input} />
                        </span>
                    </div>
                    <span className={style.labelContainer}>
                        <label className={style.label}>Correo electrónico</label>
                        <input type="text" id={style.input} className={style.mail}/>
                    </span>
    
                    <span className={style.labelContainer}>
                        <label className={style.label}>Contraseña</label>
                        <input type="text" id={style.input} className={style.password}/>
                    </span>

                    <span className={style.labelContainer}>
                        <label className={style.label}>Confirmar Contraseña</label>
                        <input type="text" id={style.input} className={style.password}/>
                    </span>

                    <span className={style.botonContainer}>
                        <button type="submit" className={style.boton}>Crear Cuenta</button>
                    </span>

                    <span className={style.registrarse}>¿Ya tienes una cuenta? <a className={style.link} href="/">Iniciar sesión</a></span>
                </form>
            </div>
    )
}