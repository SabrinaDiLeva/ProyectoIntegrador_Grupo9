import { DateRange } from 'react-date-range';
import { addDays } from 'date-fns'
import reactStyle from '../../Bloque-buscador/BuscadorReact.css';
import style from './calendario.module.css';
import { useState, useEffect } from 'react';

export default function Calendario() {
    const [range, setRange] = useState([
        {
            startDate: new Date(),
            endDate: addDays(new Date(), 7),
            key: 'selection'
        }
    ]);

    const [columns, setColumns ] = useState(1);

    useEffect( () => {
        function handleResize() {
            setColumns(window.innerWidth > 700 ? 2 : 1)
        }
        window.addEventListener('resize', handleResize)
    })


    return (
        <div className={style.calendar}>
            <DateRange
                onChange={item => setRange([item.selection])}
                editableDateInputs={true}
                moveRangeOnFirstSelection={false}
                ranges={range}
                months={columns}
                direction='horizontal'
                className={reactStyle.calendarElement}
            />
            {/*Calendario de reservas*/}
        </div>
    )
}