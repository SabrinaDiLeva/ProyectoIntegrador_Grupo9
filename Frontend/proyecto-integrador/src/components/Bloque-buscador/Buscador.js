import React, { useEffect, useRef, useState } from 'react';
import { getCiudades } from "../../service/ciudadApi"
import Boton from "../Botones/BotonLinkTo"

// Styles
import style from './Buscador.module.css';
import DisplayBusqueda from './subcomponents/DisplayBusqueda';
import Calendario from './subcomponents/Calendario';


const Buscador = () => {

    // Provincias selector state
    const [provincias, setProvincias] = useState([])
    
    useEffect(() => {
        if (provincias.length === 0) {
            getCiudades().then((data) => {
                setProvincias(data);
            })
        }
    }, [])

    return (
        <>
            <div className={style.headerBlock}>
                <h1 className={style.title}> Busca ofertas en hoteles, casas y mucho más</h1>
                <div className={style.formDondeVamos}>
                    <div className={style.container}>
                        <DisplayBusqueda provincias={provincias} />
                    </div>
                    <div className={style.container}>
                        <Calendario />
                    </div>
                    <div className={style.containerBoton}>
                        <Boton to={`/`} text={"Buscar"} />
                    </div>
                </div>
            </div>
        </>
    )

}

export default Buscador;