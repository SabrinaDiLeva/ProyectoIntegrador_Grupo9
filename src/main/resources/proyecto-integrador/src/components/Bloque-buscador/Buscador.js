import React from 'react';
import style from './Buscador.module.css';
import provincias from './provincias.json';

function Buscador() {
    return (
        <>
            <div className={style.headerBlock}>
                {/* <span className={style.title}>
                    
                </span> */}

                <div className={style.forms1}>
                    <span className={style.title}>
                        <h1> Busca ofertas en hoteles, casas y mucho mas...</h1>
                    </span>
                    <form className={style.formDondeVamos}>
                        <label for="exampleSelect"> A donde vamos ?</label>
                        <select name="exampleSelect" id="exampleSelect">
                            <option value="" disabled selected>Select an option</option>
                            {provincias.map((value) => (
                                <option value={value.key}>{value.nombre}</option>
                            ))}
                        </select>
                    </form>

                    <form className={style.formCheckIn}>
                        <label for="ckeck">Check in - Check out:</label>
                        <input type="date" id="ckeck" name="check in-out"></input>
                    </form>

                    <button className={style.botonBuscar}>Buscar</button>
                </div>
            </div>
        </>
    )

}

export default Buscador;