import { useState } from "react";
import { renderMatches } from "react-router-dom";

export const useForm = (initialForm, validateForm) => {
    const [form, setForm] = useState(initialForm);
    const [errors, setErros] = useState({});

    const credencialesValidas = {
        email:"grupo9@dh.com",
        password:"holamundo",
    };

    const handleChange = (e) => {
        const { name,value } = e.target;
        setForm({
            ...form,
            [name]:value,
        });
    };

    const handleBlur = (e) => {
        handleChange(e);
        setErros(validateForm(form));
    };

    const handleLogin = (e) => {

        e.preventDefault();
        if(form.email.trim() !== credencialesValidas.email || form.password.trim() !== credencialesValidas.password) {
            setErros({
                ...errors,
                "errorGeneral":"El usuario o contraseña son incorrectos"
            })
        }else{
            sessionStorage.setItem('sessionIniciada',JSON.stringify([{mail: form.email, password: form.password}]));
            window.history.back()
        }
    };

    const handleRegister = (e) => {
        var url = window.location.href;
        var session = JSON.parse(sessionStorage.getItem('sessionRegistrada')) || [];

        e.preventDefault();
        if(form.email.trim() === credencialesValidas.email /*|| form.email.trim() === session.email*/){
            setErros({
                ...errors,
                "errorGeneral":"El mail ingresado ya esta registrado"
            })
        }else if(form.nombre.trim() === '' || form.apellido.trim() === '' || form.email.trim() === '' || form.password.trim() === '' || form.repassword.trim() === ''){
            setErros({
                ...errors,
                "errorGeneral":"Complete todos los datos"
            })
        }else{
            session.push({mail: form.email, password: form.password, nombre: form.nombre, apellido: form.apellido})
            sessionStorage.setItem('sessionIniciada', JSON.stringify(session) )
            window.history.back()
        }
    }

    return {
        form, errors, handleChange, handleBlur, handleLogin, handleRegister
    };
};