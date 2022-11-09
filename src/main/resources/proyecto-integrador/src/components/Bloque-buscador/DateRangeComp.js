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

}

export default DateRangeComp;