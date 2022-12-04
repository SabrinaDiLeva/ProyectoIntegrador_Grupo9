import { useState } from "react";

export const useForm = (initialForm, validateForm) => {
    const [form, setForm] = useState(initialForm);
    const [errors, setErrors] = useState({});


    const handleChange = (e) => {
        const { name, value } = e.target;
        setForm({
            ...form,
            [name]: value,
        });
    };
    const handleChangeManual = (newForm) => {
        let updatedForm = form
        for (const [key, value] of Object.entries(newForm)) {
            updatedForm = {
                ...updatedForm,
                [key]: value
            }
        }
        setForm(updatedForm);
    };

    const handleSubmit = (e) => {
        handleChange(e);
        setErrors(validateForm(form));

        e.preventDefault();
        //Realizar la reserva y redireccionar o mostrar los errores en el fomulario
        // Tenemos el nombre, el apellido, el mail y la ciudad (deben existir en la api)
        // El rango de fechas elegidas por el usuario (deben estar disponibles)
        console.log(form)
    };

    return {
        form, errors, handleChange, handleChangeManual, handleSubmit
    };
};