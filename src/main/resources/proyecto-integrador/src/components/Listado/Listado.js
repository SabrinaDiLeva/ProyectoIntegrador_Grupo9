import Card from "./Card"
import style from './Listado.module.css'
import { useEffect, useState } from "react"
import { getProductosRandom } from "../../service/productoApi"
import { getImagenesPorProducto } from "../../service/imagenApi"



export default function Listado() {
    const [recomendados, setRecomendados] = useState([])
    const [portadas, setPortadas] = useState([])

    useEffect(() => {
        if (recomendados.length === 0) {
            getProductosRandom().then((data) => {
                setRecomendados(data);
            })
        }
    }, [])

    useEffect(() => {
        recomendados.forEach(producto =>{
            getImagenesPorProducto(producto.id)
                .then(data => setPortadas(oldArray => [...oldArray, data[0]]))
                .catch(() => {})
        }
        )
    }, [recomendados])

    return (
        <>
            <div className={style.tarjetaListadoContainer}>
                {(recomendados.length !== 0 && portadas.length !== 0) ? recomendados.map((producto, index) => <Card key={producto.id} id={producto.id} imagen={portadas[index]} category={producto.categoria.titulo} name={producto.nombre} title={producto.titulo} location={producto.ciudad.nombre} description={producto.descripcion}/>) : <></>}
            </div>
        </>
    )
}
