import {React} from "react";
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

    if(form.email.trim() && !regexEmail.test(form.email.trim() )){
        errors.email = "El email ingresado es incorrecto"
    }

    if( form.password.trim() && !regexName.test(form.password.trim()) ){
        errors.password = "La contraseña ingresada es incorrecta"
    }

    return errors;
};



export default function Login() {

    const {form, errors, handleChange, handleBlur, handleLogin} = useForm(initialForm, validationForm);
    
    return(
        <>
        <div className={style.container}>
            <form className={style.formulario} onSubmit={handleLogin}>
                <h1 className={style.titulo}>Iniciar sesión</h1>
                {errors.errorGeneral && <p className={style.errorGeneral}> {errors.errorGeneral} </p>}
                
                <span className={style.labelContainer}>
                    <label className={style.label}>Correo electronico</label>
                    <input id={style.mail} className={`${style.input} ${ errors.email ? style.errores : ''}`} type="email" name="email" placeholder="Escribe tu email" onBlur={handleBlur} onChange={handleChange} value={form.email} required></input>

                    <label className={style.label}>Contraseña</label>
                    <input id={style.password} className={`${style.input} ${ errors.password ? style.errores : ''}`} type="password" name="password" placeholder="Escribe tu contraseña" onBlur={handleBlur} onChange={handleChange} value={form.password} required></input>
                </span>

                <span className={style.botonContainer}>
                    <button type="submit" className={style.boton}>Ingresar</button>
                </span>
            </form>
            <span className={style.registrarse}>¿Aún no tienes cuenta?  <Link to='/registrarse' className={style.link}> Registrate </Link></span>
        </div>
        </>
    )
}
