import { useState } from "react";
//import { renderMatches } from "react-router-dom";

export const useForm = (initialForm, validateForm) => {
    const [form, setForm] = useState(initialForm);
    const [errors, setErros] = useState({});
    const url = 'http://localhost:8080'

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
        //variables de extracción
        const email = document.querySelector("input[name='email']");
        const contrasenia = document.querySelector("input[name='password']");
        //La estructura enviada
        const payload = {
            email: email.value,
            contrasenia: contrasenia.value
        };

        //la configuracion de la petición
        const settings = {
            method: 'POST',
            body: JSON.stringify(payload),
            headers: {
                'Content-Type': 'application/json'
            }
        }

        //la promesa o petición
        fetch(`${url}/auth/token`,settings)
            .then(response => {
                if (!response.ok) {
                    setErros({
                        ...errors,
                        "errorGeneral":"El usuario o contraseña son incorrectos"
                    })
                }

                return response.json();
            })
            .then(data => {
                console.log("Promesa cumplida:", data.respuesta.token);
                if (data.respuesta.token != null) {
                    //guardo en LocalStorage el objeto con el token
                    localStorage.setItem('jwt', JSON.stringify(data.respuesta.token));
                
                    //sessionStorage.setItem('jwt', JSON.stringify(data.jwt));
                    window.location.href = window.location.origin
                }
            }).catch(err => console.error(`Error: ${err}`))
    };

    const handleRegister = (e) => {
        e.preventDefault();
        const nombre = document.querySelector("input[name='nombre']");
        const apellido = document.querySelector("input[name='apellido']");
        const email = document.querySelector("input[name='email']");
        const contrasenia = document.querySelector("input[name='password']");
        const contrasenia2 = document.querySelector("input[name='repassword']");

        //La estructura enviada
        const payload = {
            nombre: nombre.value,
            apellido: apellido.value,
            email: email.value,
            contrasenia: contrasenia.value,
            ciudad: "bogota",
            rol_id: 1
        };

        //la configuracion de la petición
        const settings = {
            method: 'POST',
            body: JSON.stringify(payload),
            headers: {
                'Content-Type': 'application/json'
            }
        }
        if (contrasenia.value === contrasenia2.value) { //RESTRUCTURAR EL IF
            //la promesa o petición
            fetch(`${url}/usuario`,settings)
            .then(response => {
                console.log("Response cumplido")
                if (!response.ok) {
                    alert("Alguno de los datos es incorrecto.")
                }
                return response.json();
            })
            .then(data => {
                console.log("Promesa cumplida:", data);
                if (data != null) {

                    sessionStorage.setItem('sessionIniciada', JSON.stringify(data));
                    //window.location("/iniciar_sesion")
                }
            }).catch(err => console.error(`Error: ${err}`))
        }else if(contrasenia.value !== contrasenia2.value){
            setErros({
                ...errors,
                "errorGeneral":"La contraseña es incorrecta"
            })
        }
        form.reset();
    }

    return {
        form, errors, handleChange, handleBlur, handleLogin, handleRegister
    };
};