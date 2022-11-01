import React from "react";
import style from "./Login.module.css";


export default function Login() {
    return(
        <div>
            <div className={style.container}>
                <form>
                <h1>Iniciar sesión</h1>
                    <div>
                        <div>
                            <label className={style.texto_label}>Correo electronico</label>
                            <br/>
                            <input  className={style.barra1} type="text"></input>
                        </div>
                        <div>
                            <label className={style.texto_label}>Contraseña</label>
                            <br/>
                            <input  className={style.barra2} type="password"></input>
                        </div>
                        <button type="submit" className={style.boton}>Ingresar</button>
                    </div>
                </form>
                <span>¿Aún no tienes cuenta? <a href="/">Registrate</a></span>
            </div>
        </div>
        
    )
}

