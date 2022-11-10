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

    if (!form.nombre.trim()) {
        errors.nombre = "Ingresar tu 'nombre'"
    }else if (!regexName.test(form.nombre.trim())) {
        errors.nombre = "El nombre ingresado es incorrecto"
    }

    if (!form.apellido.trim()) {
        errors.apellido = "Ingresar tu 'apellido'"
    }else if (!regexName.test(form.apellido.trim())) {
        errors.apellido = "El apellido ingresado es incorrecto"
    }

    if (!form.email.trim()) {
        errors.email = "Ingresar tu 'email'"
    }else if (!regexEmail.test(form.email.trim())) {
        errors.email = "El email ingresado es incorrecto"
    }

    if (!form.password.trim()) {
        errors.password = "Ingresar tu 'contraseña'"
    }else if (!regexName.test(form.password.trim())) {
        errors.password = "La contraseña ingresada es incorrecta"
    }else if (form.password.trim().length < 6) {
        errors.password = "La contraseña debe contener al menos 6 caracteres"
    }

    if (!form.repassword.trim()) {
        errors.repassword = "Confirma tu 'contraseña'"
    }else if (!regexName.test(form.repassword.trim())) {
        errors.repassword = "La contraseña ingresada es incorrecta"
    }else if (form.password.trim().length < 6) {
        errors.repassword = "La contraseña debe contener al menos 6 caracteres"
    }


    return errors;
};

export default function Register() {
    const { form, errors, handleChange, handleBlur, handleSubmit } = useForm(initialForm, validationForm);
    return (
            <div className={style.container}>
<<<<<<< HEAD
                <form  className={style.formulario} onSubmit={handleSubmit}>
                    <h1 className={style.titulo}>Crear cuenta</h1>
                    <div className={style.firstContainer}>
                        <span className={style.labelContainer}>
                            <label className={style.label}>Nombre</label>
                            <input className={style.input} type="text" id={style.name}name="nombre" placeholder="Escribe tu nombre" onBlur={handleBlur} onChange={handleChange} value={form.nombre} required />
                            {errors.nombre && <p className={style.errores}> {errors.nombre} </p>}
                        </span>

                        <span className={style.labelContainer}>
                            <label className={style.label}>Apellido</label>
                            <input className={style.input} type="text" id={style.surname} name="apellido" placeholder="Escribe tu apellido" onBlur={handleBlur} onChange={handleChange} value={form.apellido} required />
                            {errors.apellido && <p className={style.errores}> {errors.apellido} </p>}
                        </span>
=======
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
>>>>>>> 5848545f0901d1e8e9b410a0924121e7298f33a0
                    </div>
                    <span className={style.labelContainer}>
                        <label className={style.label}>Correo electrónico</label>
                        <input type="email" id={style.email} className={style.input} name="email" placeholder="Escribe tu email" onBlur={handleBlur} onChange={handleChange} value={form.email} required />
                        {errors.email && <p className={style.errores}> {errors.email} </p>}
                    </span>
    
                    <span className={style.labelContainer}>
                        <label className={style.label}>Contraseña</label>
                        <input type="text" id={style.password} className={style.input}name="password" placeholder="Escribe tu contraseña" onBlur={handleBlur} onChange={handleChange} value={form.password} required />
                        {errors.password && <p className={style.errores}> {errors.password} </p>}
                    </span>

                    <span className={style.labelContainer}>
                        <label className={style.label}>Confirmar Contraseña</label>
                        <input type="text" id={style.repassword} className={style.input}name="repassword" placeholder="Escribe tu contraseña" onBlur={handleBlur} onChange={handleChange} value={form.repassword} required />
                        {errors.repassword && <p className={style.errores}> {errors.repassword} </p>}
                    </span>

                    <span className={style.botonContainer}>
                        <button type="submit" className={style.boton}>Crear Cuenta</button>
                    </span>

                    <span className={style.registrarse}>¿Ya tienes una cuenta? <Link to='/iniciar_sesion' className={style.link}>Iniciar Sesion</Link></span>
                </form>
            </div>
    )
}