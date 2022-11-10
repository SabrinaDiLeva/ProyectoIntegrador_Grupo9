import {React, useState} from "react";
import style from "./login.module.css";
import { useForm } from "../../hooks/useForm";
import { Link } from "react-router-dom";



const initialForm = {
    email:"",
    password:"",
}; 

const validationForm = (form) => {
    let errors = {};
    let regexName = /^[A-Za-zÑñÁáÉéÍíÓóÚúÜü\s]+$/;
    let regexEmail = /^(\w+[/./-]?){1,}@[a-z]+[/.]\w{2,}$/;

    if(!form.email.trim()){
        errors.email = "El campo 'email' es requerido"
    } else if(!regexEmail.test(form.email.trim())) {
        errors.email = "El email ingresado es incorrecto"
    }

    if(!form.password.trim()){
        errors.password = "El campo 'contraseña' es requerido"

    } else if(!regexName.test(form.password.trim())) {
        errors.password = "La contraseña ingresada es incorrecta"

    } else if(form.password.trim().length < 6){
        errors.password = "La contraseña debe contener al menos 6 caracteres"
    }

    return errors;
};



export default function Login() {

    const {form, errors, handleChange, handleBlur, handleSubmit} = useForm(initialForm, validationForm);
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

