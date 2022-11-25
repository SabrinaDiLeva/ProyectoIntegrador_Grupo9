import style from "./datosPersonales.module.css"
import { useEffect, useState } from "react";

const session = sessionStorage.getItem('sessionRegistrada')

export default function DatosPersonales() {

    const [name, setName] = useState("User's name");
    const [lastname, setLastname] = useState("User's lastname");
    const [email, setEmail] = useState("User's email");
    const [ciudad, setCiudad] = useState("");

    if(session){
        var loggedUser = {
          mail: JSON.parse(session)[0].mail,
          password: JSON.parse(session)[0].password,
          name: `${JSON.parse(session)[0].nombre.charAt(0).toUpperCase()}${JSON.parse(session)[0].nombre.slice(1)}`,
          apellido: `${JSON.parse(session)[0].apellido.charAt(0).toUpperCase()}${JSON.parse(session)[0].apellido.slice(1)}`,
        }
    }

    useEffect(() => {
      if(loggedUser){
        setName(loggedUser.name)
        setLastname(loggedUser.apellido)
        setEmail(loggedUser.mail)
      }
    })

    return (
        <span className={style.labelContainer}>
            <div>
                <label className={style.label}>Nombre</label>
                <input id={style.password} className={style.input} type="text" name="nombre" placeholder={name} disabled></input>
            </div>

            <div>
                <label className={style.label}>Apellido</label>
                <input id={style.password} className={style.input} type="text" name="apellido" placeholder={lastname} disabled></input>
            </div>

            <div>
                <label className={style.label}>Correo electronico</label>
                <input id={style.mail} className={style.input} type="email" name="email" placeholder={email} disabled></input>
            </div>

            <div>
                <label className={style.label}>Ciudad</label>
                <input id={style.password} className={style.input} type="text" name="ciudad" placeholder={ciudad === '' ? 'Ciudad' : ciudad}></input>
            </div>
        </span>
    )
}