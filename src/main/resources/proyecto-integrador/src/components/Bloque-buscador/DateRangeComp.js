import React, {useEffect, useRef, useState} from 'react';
import style from './Buscador.module.css';
import provincias from './provincias.json';
import { Calendar } from 'react-date-range';
import format from 'date-fns/format';
import 'react-date-range/dist/styles.css'; // main css file
import 'react-date-range/dist/theme/default.css'; // theme css file

const DateRangeComp = () => {
        // date State
    const [calendar, setCalendar] = useState('');

    // Open Close state
    const [open, setOpen] = useState(false);
    
    // get the target element to toggle calendar
    const refOne = useRef(null)

    useEffect(() => {
        // set current date on component
        setCalendar(format(new Date(), 'dd/MM/yyyy'))
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

    const handleSelect = (date) => {
        setCalendar(format(date, 'dd/MM/yyyy'))
    }


    return (
        <div className={style.calendarWrap}>
            <input
                value={calendar}
                readOnly
                className={style.inputBox}
                onClick={()=> setOpen(open => !open)}
            />
            <div ref={refOne}>
                {open && 
                    <Calendar
                        date = {new Date()}
                        onChange = {handleSelect}
                        className={style.calendarElement}
                    />
                }
            </div>
        </div>
    )
















    

    // const [open, setOpen] = useState(false);
    // useEffect(() => {
    //     setCalendar(format(new Date(), 'dd/MM/yyyy'))
    // }, []);



//     return (
//         <>
//             <div className={style.headerBlock}>
//                 {/* <span className={style.title}>
                    
//                 </span> */}

//                 <div className={style.forms1}>
//                     <span className={style.title}>
//                         <h1> Busca ofertas en hoteles, casas y mucho mas...</h1>
//                     </span>
//                     <form className={style.formDondeVamos}>
//                         <label for="exampleSelect"> A donde vamos ?</label>
//                         <select name="exampleSelect" id="exampleSelect">
//                             <option value="" disabled selected>Select an option</option>
//                             {provincias.map((value) => (
//                                 <option value={value.key}>{value.nombre}</option>
//                             ))}
//                         </select>
//                     </form>

//                     <form className={style.formCheckIn}>
//                         <label for="ckeck">Check in - Check out:</label>
//                        <DateRange
//                         editableDateInputs={true}
//                         onChange={item => setState([item.selection])}
//                         moveRangeOnFirstSelection={false}
//                         rangeColors={['#FBC02D']}
//                         ranges={state}
//                         />
//                         {/* <input type="date" id="ckeck" name="check in-out"></input> */}
//                     </form>

//                     <button className={style.botonBuscar}>Buscar</button>
//                 </div>
//             </div>
//         </>
//     )

}

export default DateRangeComp;