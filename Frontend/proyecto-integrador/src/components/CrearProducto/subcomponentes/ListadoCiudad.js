import React, {useState, useEffect} from 'react';
import style from "./ListadoCiudad.module.css"
import { Icons } from "../../ui/icons"
import { getCiudades } from "../../../service/ciudadApi"

export default function ListadoCiudad(props) {
    const [provincias, setProvincias] = useState([]);
    const [searchTermCiudades, setSearchTermCiudades] = useState("");
    const [searchResultsCiudades, setSearchResultsCiudades] = useState([]);
    
    // Obtener Ciudades
    useEffect(() => {
        if (provincias.length === 0) {
            getCiudades().then((data) => {
                setProvincias(data);
            })
        }
    }, [])

    useEffect(() => { setSearchResultsCiudades(provincias) }, [searchTermCiudades, provincias]);

    return (
        <>
        {searchResultsCiudades.map((value) =>
            <a href='#' className={style.locations}>
                <span> {Icons.location} </span>
                <span className={style.liContainer}>
                    <li className={style.opcionProvincia}>{value.nombre}</li>
                    <li className={style.opcionPais}>{value.pais}</li>
                </span>
            </a>
        )}
        </>
    )
}
