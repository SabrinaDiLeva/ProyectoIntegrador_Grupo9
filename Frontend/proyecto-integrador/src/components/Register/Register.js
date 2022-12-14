import React from "react";
import style from "./register.module.css";
import { useForm } from "../../hooks/useForm";
import { Link } from "react-router-dom";

const initialForm = {
    nombre: "",
    apellido: "",
    email: "",
    password: "",
    repassword: "",
};

const validationForm = (form) => {
    let errors = {};
    let regexName = /^[A-Za-zÑñÁáÉéÍíÓóÚúÜü\s]+$/;
    let regexEmail = /^(\w+[/./-]?){1,}@[a-z]+[/.]\w{2,}$/;
    let regexPassword = /^(?=\w*\d)(?=\w*[A-Z])(?=\w*[a-z])\S{6,8}$/;

    if (!form.nombre.trim()) {
        errors.nombre = "Ingresar tu 'nombre'"
    }else if (!regexName.test(form.nombre.trim())) {
        errors.nombre = "El nombre ingresado es incorrecto"
    }else{
        errors.nombre = ""
    }

    if (!form.apellido.trim()) {
        errors.apellido = "Ingresar tu 'apellido'"
    }else if (!regexName.test(form.apellido.trim())) {
        errors.apellido = "El apellido ingresado es incorrecto"
    }else{
        errors.apellido = ""
    }

    if (!form.email.trim()) {
        errors.email = "Ingresar tu 'email'"
    }else if (!regexEmail.test(form.email.trim())) {
        errors.email = "El email ingresado es incorrecto"
    }else{
        errors.email = ""
    }

    if (!form.password.trim()) {
        errors.password = "Ingresar tu 'contraseña'"
    }else if (!regexPassword.test(form.password.trim())) {
        errors.password = "La contraseña ingresada es incorrecta"
    }else if (form.password.trim().length < 6) {
        errors.password = "La contraseña debe contener al menos 6 caracteres"
    }else{
        errors.password = ""
    }

    if (!form.repassword.trim()) {
        errors.repassword = "Confirma tu 'contraseña'"
    }else if (!regexPassword.test(form.repassword.trim())) {
        errors.repassword = "La contraseña ingresada es incorrecta"
    }else if (form.password.trim().length < 6) {
        errors.repassword = "La contraseña debe contener al menos 6 caracteres"
    }else{
        errors.repassword = ""
    }

    return errors;
};

export default function Register() {
    const {form, errors, handleChange, handleBlur, handleRegister} = useForm(initialForm, validationForm);
    return (
            <div className={style.container}>
                <form  className={style.formulario} onSubmit={handleRegister}>
                    <h1 className={style.titulo}>Crear cuenta</h1>
                    
                    {errors.errorGeneral && <p className={style.errorGeneral}> {errors.errorGeneral} </p>}
                    <div className={style.firstContainer}>
                        <span className={style.labelContainer}>
                            <label className={style.label}>Nombre</label>
                            <input className={style.input} type="text" id={style.name} name="nombre" placeholder="Escribe tu nombre" onBlur={handleBlur} onChange={handleChange} value={form.nombre} required />
                        </span>

                        <span className={style.labelContainer}>
                            <label className={style.label}>Apellido</label>
                            <input className={style.input} type="text" id={style.surname} name="apellido" placeholder="Escribe tu apellido" onBlur={handleBlur} onChange={handleChange} value={form.apellido} required />
                        </span>
                    </div>
                    <span className={style.labelContainer}>
                        <label className={style.label}>Correo electrónico</label>
                        <input type="email" id={style.email} className={style.input} name="email" placeholder="Escribe tu email" onBlur={handleBlur} onChange={handleChange} value={form.email} required />
                    </span>
    
                    <span className={style.labelContainer}>
                        <label className={style.label}>Contraseña</label>
                        <input type="password" id={style.password} className={style.input} name="password" placeholder="Escribe tu contraseña" onBlur={handleBlur} onChange={handleChange} value={form.password} required />
                    </span>

                    <span className={style.labelContainer}>
                        <label className={style.label}>Confirmar Contraseña</label>
                        <input type="password" id={style.repassword} className={style.input} name="repassword" placeholder="Escribe tu contraseña" onBlur={handleBlur} onChange={handleChange} value={form.repassword} required />
                    </span>

                    <span className={style.botonContainer}>
                        <button type="submit" className={style.boton}>Crear Cuenta</button>
                    </span>

                    <span className={style.registrarse}>¿Ya tienes una cuenta? <Link to='/iniciar_sesion' className={style.link}>Iniciar Sesion</Link></span>
                </form>
            </div>
    )
}

