import style from "./datosPersonales.module.css"
import { useEffect, useState } from "react";


const session = localStorage.getItem('jwt');


export default function DatosPersonales() {

    const [name, setName] = useState("User's name");
    const [lastname, setLastname] = useState("User's lastname");
    const [email, setEmail] = useState("User's email");
    const [ciudad, setCiudad] = useState("");

    if(session){
        let base64Url = session.split('.')[1];
        //let base64 = base64Url.replace('-', '+').replace('_', '/');
        const decode = atob(base64Url);
        var loggedUser = {
            nameLetter: `${JSON.parse(decode).name[0].toUpperCase()}`,
            lastNameLetter: `${JSON.parse(decode).lastName[0].toUpperCase()}`,
            name: `${JSON.parse(decode).name[0].toUpperCase()}${JSON.parse(decode).name.slice(1)}`,
            lastname: `${JSON.parse(decode).lastName[0].toUpperCase()}${JSON.parse(decode).lastName.slice(1)}`
          }
    }

    useEffect(() => {
      if(loggedUser){
        setName(loggedUser.name)
        setLastname(loggedUser.lastname)
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