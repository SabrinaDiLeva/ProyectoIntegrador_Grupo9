import React from "react";
import style from "./register.module.css";
import { useForm } from "../../hooks/useForm";

const initialForm = {
    nombre: "",
    apellido: "",
    email: "",
    password: "",
    password2: "",
};

const validationForm = (form) => {
    let errors = {};
    let regexName = /^[A-Za-zÑñÁáÉéÍíÓóÚúÜü\s]+$/;
    let regexEmail = /^(\w+[/./-]?){1,}@[a-z]+[/.]\w{2,}$/;
    let regexComments = /^.{1,6}$/;

    if (!form.nombre.trim()) {
        errors.nombre = "El campo 'nombre' es requerido"
    } else if (!regexName.test(form.nombre.trim())) {
        errors.nombre = "El nombre ingresado es incorrecto"
    }
    if (!form.apellido.trim()) {
        errors.apellido = "El campo 'apellido' es requerido"
    } else if (!regexName.test(form.apellido.trim())) {
        errors.apellido = "El apellido ingresado es incorrecto"
    }

    if (!form.email.trim()) {
        errors.email = "El campo 'email' es requerido"
    } else if (!regexEmail.test(form.email.trim())) {
        errors.email = "El email ingresado es incorrecto"
    }

    if (!form.password.trim()) {
        errors.password = "El campo 'contraseña' es requerido"
    } else if (!regexName.test(form.password.trim())) {
        errors.password = "La contraseña ingresada es incorrecta"
    } else if (form.password.trim().length < 6) {
        errors.password = "La contraseña debe contener al menos 6 caracteres"
    }

    if (!form.password2.trim()) {
        errors.password2 = "El campo 'contraseña' es requerido"
    } else if (!regexName.test(form.password2.trim())) {
        errors.password2 = "La contraseña ingresada es incorrecta"
    } else if (form.password.trim().length < 6) {
        errors.password2 = "La contraseña debe contener al menos 6 caracteres"
    }


    return errors;
};

export default function Register() {
    const { form, errors, loading, response, handleChange, handleBlur, handleSubmit } = useForm(initialForm, validationForm);
    return (
        <div>
            <div className={style.container}>
                <form onSubmit={handleSubmit}>
                    <h1>Crear cuenta</h1>
                    <div>
                        <div className={style.uno}>
                            <div className={style.dos}>
                                <label >Nombre</label>
                                <input width="13.5rem" type="text" id="name" name="nombre" placeholder="Escribe tu nombre" onBlur={handleBlur} onChange={handleChange} value={form.nombre} required />
                                {errors.nombre && <p> {errors.nombre} </p>}
                            </div>
                            <div className={style.dos}>
                                <label >Apellido</label>
                                <input width="13.5rem" type="text" id="surname" name="apellido" placeholder="Escribe tu apellido" onBlur={handleBlur} onChange={handleChange} value={form.apellido} required />
                                {errors.apellido && <p> {errors.apellido} </p>}
                            </div>
                        </div>
                        <label>Correo electrónico</label>
                        <br />
                        <input type="text" name="email" placeholder="Escribe tu email" onBlur={handleBlur} onChange={handleChange} value={form.email} required />
                        {errors.email && <p> {errors.email} </p>}
                        <br />
                        <label>Contraseña</label>
                        <br />
                        <input type="text" name="password" placeholder="Escribe tu contraseña" onBlur={handleBlur} onChange={handleChange} value={form.password} required />
                        {errors.password && <p> {errors.password} </p>}
                        <br />
                        <label>Confirmar Contraseña</label>
                        <br />
                        <input type="text" name="password2" placeholder="Escribe tu contraseña" onBlur={handleBlur} onChange={handleChange} value={form.password2} required />
                        {errors.password2 && <p> {errors.password2} </p>}
                    </div>
                    <button type="submit">Crear Cuenta</button>
                    <br />
                    <span>¿Ya tienes una cuenta? <a href="/">Iniciar sesión</a></span>
                </form>

            </div>
        </div>

    )
}