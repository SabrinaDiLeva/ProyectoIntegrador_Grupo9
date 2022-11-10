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
                console.log(`DATA: ${typeof data}`);
                setRecomendados(data);
                console.log(`RECOMENDADOS: ${recomendados}`);
            })
        }
    }, [])

    useEffect(() => {
        recomendados.forEach(producto =>
            getImagenesPorProducto(producto.id)
                .then(data => setPortadas(oldArray => [...oldArray, data.length]))
                .catch(() => "")
        )
        console.log(`PORTADAS: ${portadas}`);
        console.log(`RECOMENDADOS: ${recomendados}`);

    }, [recomendados])

    return (
        <>
            <div className={style.tarjetaListadoContainer}>
                {recomendados.map((producto, index) => <Card key={producto.id} imagen={portadas[index].url} category={producto.categoria} name={producto.nombre} title={producto.titulo} location={producto.ciudad} description={producto.descripcion} />
                )}
            </div>
        </>
    )
}
