import { DateRange } from 'react-date-range';
import { addDays } from 'date-fns'
import reactStyle from './calendarioRange.css';
import style from './calendario.module.css';
import { useState, useEffect } from 'react';

export default function Calendario(props) {
    const [range, setRange] = useState([
        {
            startDate: new Date(),
            endDate: addDays(new Date(), 7),
            key: 'selection'
        }
    ]);

    const [columns, setColumns] = useState(1);

    useEffect( () => {
        function handleResize() {
            setColumns(window.innerWidth > 700 ? 2 : 1)
        }
        window.addEventListener('resize', handleResize)
    })

    const actualizarRango = (item) => {
        let date = item.selection.startDate
        let checkin = `${date.getDate()}/${date.getMonth()}/${date.getFullYear()}`;
        date = item.selection.endDate
        let checkout = `${date.getDate()}/${date.getMonth()}/${date.getFullYear()}`;

        setRange([item.selection]);
        props.handleChange({
            "checkInDate": checkin,
            "checkOutDate": checkout,
        })

    }


    return (
        <div className={style.calendar}>
            <DateRange
                onChange={item => actualizarRango(item)}
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