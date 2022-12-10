import React, {useState, useEffect} from 'react';
import style from "./ListadoCategoria.module.css"
import { Icons } from '../../ui/icons';
import { getCategorias } from "../../../service/categoriaApi"

export default function ListadoCiudad(props) {
    const [categorias, setCategorias] = useState([]);
    const [searchTermCategoria, setSearchTermCategoria] = useState("");
    const [searchResultsCategoria, setSearchResultsCategoria] = useState([]);

    // Obtener Categorias
    useEffect(() => {
        if (categorias.length === 0) {
            getCategorias().then((data) => {
                setCategorias(data);
            })
        }
    }, [])

    useEffect(() => { setSearchResultsCategoria(categorias) }, [searchTermCategoria, categorias])

    return (
        <>
        {searchResultsCategoria.map((value) => 
            <a href='/' className={style.categoria}>
                <span className={style.liContainer}>
                    {console.log(value)}
                    <li className={style.opcionProvincia}>{value.titulo}</li>
                </span>
            </a>
        )}
        </>
    )
}