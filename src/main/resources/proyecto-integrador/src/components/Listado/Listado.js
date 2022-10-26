import Card from "./Card"
import data from "./data.json"
import style from './Listado.module.css'


export default function Listado(){
    const productos = data

    return (
        <>
        <div classname={style.containter}>
            <div className={style.tarjetaContainer}>
                { productos.map( (producto) => {
                    return <Card key={producto.key} imagen={producto.imagen} category={producto.category} name={producto.name} title={producto.title} location={producto.location} description={producto.description}/>
                })}
            </div>
        </div>
        </>
    )
}

