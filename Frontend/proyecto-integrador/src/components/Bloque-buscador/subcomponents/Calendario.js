import { DateRange } from 'react-date-range';
import { addDays } from 'date-fns'
import React, { useEffect, useRef, useState } from 'react';
import style from './calendario.module.css';
import format from 'date-fns/format';
import reactStyle from './BuscadorReact.css';

export default function Calendario(props) {
    const [columns, setColumns] = useState(1);
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

    // Hide dropdown on ESC press
    const hideOnEscape = (e) => {
        if (e.key === 'Escape') {
            setOpen(false)
        }
    }

    // Hide on outside click
    const hideOnClickOutside = (e) => {
        if (refOne.current && !refOne.current.contains(e.target)) {
            setOpen(false)
        }
    }

    useEffect(() => {
        // set current date on component
        document.addEventListener('keydown', hideOnEscape, true)
        document.addEventListener('click', hideOnClickOutside, true)
    }, []);
    
    useEffect( () => {
        function handleResize() {
            setColumns(window.innerWidth > 1024 ? 2 : 1)
        }
        window.addEventListener('resize', handleResize)
    })

    return (
        <div className={style.calendarWrap}>
            <input 
                value={`${format(range[0].startDate, "dd/MM/yyyy")} to ${format(range[0].endDate, "dd/MM/yyyy")}`}
                readOnly
                className={style.inputCalendario}
                onClick={() => setOpen(open => !open)}
            />
            <div className={style.calendario} ref={refOne}>
                {open &&
                    <DateRange
                        onChange={item => setRange([item.selection])}
                        editableDateInputs={true}
                        moveRangeOnFirstSelection={false}
                        ranges={range}
                        months={columns}
                        direction='horizontal'
                        className={reactStyle.calendarElement}
                    />
                }
            </div>
        </div>
    )
}