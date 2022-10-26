import React from 'react';
import './Buscador.css';
import provincias from './provincias.json';

function Buscador() {
    return (
        <div className='header-block'>
            <div className='title'>
                <h1> Buscar ofertas en hoteles, casas y mucho mas</h1>
            </div>

            <div className='forms1'>
                <form>
                    <label for="exampleSelect"> A donde vamos ?</label>
                    <select name="exampleSelect" id="exampleSelect">
                        <option value="" disabled="disabled" selected="">Select an option</option>
                       {provincias.map((value) => (
                        <option value={value.key}>{value.nombre}</option>
                       ))}
                    </select>
                </form>
                        
                
                <form>
                    <label for="ckeck">Check in - Check out:</label>
                    <input type="date" id="ckeck" name="check in-out"></input>
                </form>

                <button>Buscar</button>
            </div>
        </div>

    )

}

export default Buscador;