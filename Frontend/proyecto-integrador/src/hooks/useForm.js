import { useState } from "react";
import { renderMatches } from "react-router-dom";

export const useForm = (initialForm, validateForm) => {
    const [form, setForm] = useState(initialForm);
    const [errors, setErros] = useState({});

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
        // e.preventDefault();
        // if(form.email.trim() !== credencialesValidas.email || form.password.trim() !== credencialesValidas.password) {
        //     setErros({
        //         ...errors,
        //         "errorGeneral":"El usuario o contraseña son incorrectos"
        //     })
        // }else{
        //     sessionStorage.setItem('sessionIniciada',JSON.stringify([{mail: form.email, password: form.password}]));
        //     window.history.back()
        // }

        const email = document.querySelector("input[name='email']");
        const contrasenia = document.querySelector("input[name='password']");
        const url = 'http://localhost:8080/auth/token'

        const payload = {
            email: email.value,
            contrasenia: contrasenia.value
        };

        const settings = {
            method: 'POST',
            body: JSON.stringify(payload),
            headers: {
                'Content-Type': 'application/json'
            }
        }
        console.log("LA RESPUESTA ENVIADA", JSON.stringify(payload))
        fetch(url,settings)
            .then(response => {
                if (!response.ok) {
                    alert("Alguno de los datos es incorrecto.")
                }

                return response.json();
            })
            .then(data => {
                console.log("Promesa cumplida:", data.respuesta.token);

                if (data.respuesta.token != null) {
                    //guardo en LocalStorage el objeto con el token
                    localStorage.setItem('jwt', JSON.stringify(data.respuesta.token));


                    //window.history.back()
                }
                
            }).catch(err => console.error(`Error: ${err}`))
    };

    const handleRegister = (e) => {
        var url = window.location.href;
        var session = JSON.parse(sessionStorage.getItem('sessionRegistrada')) || [];

        e.preventDefault();
        if(true){
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
            sessionStorage.setItem('sessionRegistrada', JSON.stringify(session) )
            window.history.back()
        }
    }

    return {
        form, errors, handleChange, handleBlur, handleLogin, handleRegister
    };
};