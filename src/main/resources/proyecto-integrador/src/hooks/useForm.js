import { useState } from "react";

export const useForm = (initialForm, validateForm) => {
    const [form, setForm] = useState(initialForm);
    const [errors, setErros] = useState({});
    const [loading, setLoading] = useState(false);
    const [response, setResponse] = useState(null);

    const credencialesValidas = {
        email:"marcos.ferro@gmail.com",
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

        if(form.email.trim() != credencialesValidas.email || form.password.trim() != credencialesValidas.password) {
            setErros({
                ...errors,
                ["email"]:"Usuario incorrecto"
            })
        }
    };

    return {
        form, errors, loading, response, handleChange, handleBlur, handleSubmit
    };
};