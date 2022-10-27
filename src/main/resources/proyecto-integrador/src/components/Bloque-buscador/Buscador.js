import React, {useEffect, useRef, useState} from 'react';
import provincias from './provincias.json';
import { DateRange} from 'react-date-range';
import {addDays} from 'date-fns'

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

    return (
        <>
            <div className={style.headerBlock}>
                <div className={style.forms1}>
                    <span className={style.title}>
                        <h1> Busca ofertas en hoteles, casas y mucho mas...</h1>
                    </span>
                    <span className={style.formDondeVamos}>
                        <div className={style.opcionContainer}>
                            <input className={style.inputDestino} list='inputListado' placeholder='¿A dónde vamos?' onkeyup="filterFunction()"></input>
                            <datalist className={style.inputListado} id='inputListado'>
                                {provincias.map((value) => (
                                    <option className={style.inputOpciones} value={value.nombre}></option>
                                ))}
                            </datalist>

                        </div>
                        {/* <form>
                            <select name="exampleSelect" id="exampleSelect">
                                <option value="" disabled selected>Select an option</option>
                                
                            </select>
                        </form> */}
                    
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
                                        months={2}
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