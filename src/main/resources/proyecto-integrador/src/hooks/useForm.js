import { useState } from "react";

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

    const handleSubmit = (e) => {
        e.preventDefault();

        if(form.email.trim() !== credencialesValidas.email || form.password.trim() !== credencialesValidas.password) {
            setErros({
                ...errors,
                "errorGeneral":"El usuario o contraseña son incorrectos"
            })
        }
    };

    return {
        form, errors, handleChange, handleBlur, handleSubmit
    };
};