import React, {useEffect, useRef, useState} from 'react';
import { DateRange} from 'react-date-range';
import {addDays} from 'date-fns'
import { getCiudades } from "../../service/ciudadApi"

// Styles
import format from 'date-fns/format';
import style from './Buscador.module.css';
import reactStyle from './BuscadorReact.css';


const Buscador = () => {
        // date State
    const [range, setRange] = useState([
        {
            startDate: new Date(),
            endDate: addDays(new Date(), 7),
            key: 'selection'
        }
    ]);

    const [provincias, setProvincias] = useState([])

    useEffect(() => {
        if (provincias.length === 0) {
            getCiudades().then((data) => {
                setProvincias(data);
            })
        }
    }, [])

    // Open Close state
    const [open, setOpen] = useState(false);
    
    // get the target element to toggle calendar
    const refOne = useRef(null)

    useEffect(() => {
        // set current date on component
        document.addEventListener('keydown', hideOnEscape, true)
        document.addEventListener('click', hideOnClickOutside, true)
    }, []);

    // Hide dropdown on ESC press
    const hideOnEscape = (e) => {
        if(e.key === 'Escape'){
            setOpen(false)
        }
    }

    // Hide on outside click
    const hideOnClickOutside = (e) => {
        if(refOne.current && !refOne.current.contains(e.target)){
            setOpen(false)
        }
    }

    const [searchTerm, setSearchTerm] = useState("");
    const [searchResults, setSearchResults] = useState([]);
    const handleChange = event => {
        setSearchTerm(event.target.value);
    };

    function showHide() {
        var listado = document.getElementById(style.listadoSelection);
        var input = document.getElementById("inputDestino");

        input.addEventListener('focus', function() {
            listado.style.display = 'block';
        });
        input.addEventListener('focusout', function() {
            listado.style.display = 'none';
        });
    }

    useEffect(() => {
        const results = provincias.filter(prov =>
            prov.nombre.toLowerCase().includes(searchTerm)
        );
        setSearchResults(results);
    }, [searchTerm]);

    

    return (
        <>
        <div className={style.headerBlock}>
            <div className={style.forms1}>
                <span className={style.title}>
                    <h1> Busca ofertas en hoteles, casas y mucho mas</h1>
                </span>
                <span className={style.formDondeVamos}>
                    <div className={style.opcionContainer} ref={refOne}>
                        <input id="inputDestino" className={style.inputDestino} type="search" value={searchTerm} onChange={handleChange} onClick={showHide} placeholder="¿A dónde vamos?"></input>
                        <div className={style.opcionContainer2}>
                            <ul className={style.inputListado} id={style.listadoSelection} >
                                {searchResults.map((value) => (
                                    <a href='/' className={style.locations}>
                                        <iconify-icon icon="charm:map-pin"></iconify-icon>
                                        <span className={style.liContainer}>
                                                <li className={style.opcionProvincia}>{value.nombre}</li>
                                                <li className={style.opcionPais}>{value.pais}</li>
                                        </span>
                                    </a>
                                ))}
                            </ul>
                        </div>
                    </div>

                    <div className={style.calendarWrap}>
                        <input
                            value={`${format(range[0].startDate, "dd/MM/yyyy")} to ${format(range[0].endDate, "dd/MM/yyyy")}`}
                            readOnly
                            className={style.inputCalendario}
                            onClick={()=> setOpen(open => !open)}
                        />
                        <div className={style.calendario} ref={refOne}>
                            {open && 
                                <DateRange
                                    onChange={item => setRange([item.selection])}
                                    editableDateInputs={true}
                                    moveRangeOnFirstSelection={false}
                                    ranges={range}
                                    months={window.innerWidth > 767 ? 2 : 1}
                                    direction='horizontal'
                                    className={reactStyle.calendarElement}
                                />
                            }
                        </div>
                    </div>
                    <button className={style.botonBuscar}>Buscar</button>
                </span>   
            </div>
        </div>
        </>
    )

}

export default Buscador;