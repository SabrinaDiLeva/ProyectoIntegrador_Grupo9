import React from "react";
import style from "./login.module.css";
import { useForm } from "../../hooks/useForm";

const initialForm = {
    email:"",
    password:"",
}; 

const validationForm = (form) => {
    let errors = {};
    let regexName = /^[A-Za-zÑñÁáÉéÍíÓóÚúÜü\s]+$/;
    let regexEmail = /^(\w+[/./-]?){1,}@[a-z]+[/.]\w{2,}$/;
    let regexComments = /^.{1,6}$/;


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

    // if(form.email.trim() != credencialesValidas.email || form.password.trim() != credencialesValidas.password) {
    //     errors.email = "Usuario incorrecto"
    // }


    return errors;
};

export default function Login() {
    const {form,errors,loading,response,handleChange,handleBlur,handleSubmit} = useForm(initialForm,validationForm);
    return(
        <div>
            <div className={style.container}>
                <form onSubmit={handleSubmit}>
                <h1>Iniciar sesión</h1>
                    <div>
                        <div>
                            <label className={style.texto_label}>Correo electronico</label>
                            <br/>
                            <input  className={style.barra1} type="email" name="email" placeholder="Escribe tu email" onBlur={handleBlur} onChange={handleChange} value={form.email} required ></input>
                            {errors.email && <p> {errors.email} </p>}
                        </div>
                        <div>
                            <label className={style.texto_label}>Contraseña</label>
                            <br/>
                            <input  className={style.barra2} type="password" name="password" placeholder="Escribe tu contraseña" onBlur={handleBlur} onChange={handleChange} value={form.password} required></input>
                            {errors.password && <p> {errors.password} </p>}
                        </div>
                        <button type="submit" className={style.boton}>Ingresar</button>
                    </div>
                </form>
                <span>¿Aún no tienes cuenta? <a href="/">Registrate</a></span>
            </div>
        </div>
        
    )
}

