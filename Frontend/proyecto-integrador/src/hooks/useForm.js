import { useState } from "react";

export const useForm = (initialForm, validateForm) => {
    const [form, setForm] = useState(initialForm);
    const [errors, setErrors] = useState({});

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

    const handleSubmit = (e) => {
        handleChange(e);
        setErrors(validateForm(form));

        var url = window.location.href

        e.preventDefault();
        if(form.email.trim() !== credencialesValidas.email || form.password.trim() !== credencialesValidas.password) {
            setErrors({
                ...errors,
                "errorGeneral":"El usuario o contraseña son incorrectos"
            })
        }else{
            sessionStorage.setItem('sessionIniciada',JSON.stringify([{mail: form.email, password: form.password}]));
            window.location.href = url.substring(0,window.location.href.indexOf('iniciar'))
        }
    };

    return {
        form, errors, handleChange, handleSubmit
    };
};