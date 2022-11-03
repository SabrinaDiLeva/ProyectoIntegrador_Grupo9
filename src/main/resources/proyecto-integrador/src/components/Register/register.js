import React from "react";
import style from "./register.module.css";


export default function Register() {
    return(
        <div>
            <div className={style.container}>
                <form>
                    <h1>Crear cuenta</h1>
                    <div>
                        <div className={style.uno}>
                            <div className={style.dos}>
                                <label >Nombre</label>
                                <input width="13.5rem" type="text" id="name"/>
                            </div>
                            <div className={style.dos}>
                                <label >Apellido</label>
                                <input width="13.5rem" type="text" id="surname" />
                            </div>
                        </div>
                        <label>Correo electrónico</label>
                        <br/>
                        <input type="text" id="email"/>
                        <br/>
                        <label>Contraseña</label>
                        <br/>
                        <input  type="text" id="password"/>
                        <br/>
                        <label>Confirmar Contraseña</label>
                        <br/>
                        <input  type="text" id="passwordConfirmada"/>
                    </div>
                    <button type="submit">Crear Cuenta</button>
                    <br/>
                    <span>¿Ya tienes una cuenta? <a href="/">Iniciar sesión</a></span>
                </form>
                
            </div>
        </div>
        
    )
}