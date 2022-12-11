import React, { useEffect, useRef, useState } from 'react';
import style from "./displayBusqueda.module.css"
import Location from "./Location"

export default function DisplayBusqueda(props) {
    // get the target element to toggle calendar
    const refOne = useRef(null)
    const [searchTerm, setSearchTerm] = useState("");
    const [searchResults, setSearchResults] = useState([]);

    const handleChange = event => {
        setSearchTerm(event.target.value);
    };

    const setBuscador = (term) => {
        var listado = document.getElementById("inputListado");

        setSearchTerm(term);

        listado.style.display = 'none';
    }

    useEffect(() => {
        const results = (searchTerm.length < 3)? [] : props.provincias.filter(prov =>
            prov.nombre.toLowerCase().includes(searchTerm.toLowerCase())
        );
        setSearchResults(results);
    }, [searchTerm, props.provincias]);

    /*
        Permite esconder el listado de resultados.
    */
    useEffect( () => {
        var listado = document.getElementById("inputListado");
        listado.style.display = 'none';
        var input = document.getElementById("inputDestino");
        input.addEventListener('focus', function () {
            listado.style.display = 'block';
        });
    
        input.addEventListener('focusout', function () {
            //listado.style.display = 'none';
        });
    }, [] );

    return (
        <div className={style.opcionContainer} ref={refOne}>
            <input id="inputDestino" className={style.inputDestino} type="search" value={searchTerm} onChange={handleChange} placeholder={`¿A dónde vamos?`}></input>
            <ul className={style.inputListado} id="inputListado" >
                {searchResults.map((value) => <Location key={value.nombre} provincia={value} setBuscador={setBuscador} />)}
            </ul>
        </div>
    )
}