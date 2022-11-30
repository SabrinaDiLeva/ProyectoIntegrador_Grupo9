import Card from "./Card"
import style from './Listado.module.css'
import { useEffect, useState } from "react"
import { getProductosRandom } from "../../service/productoApi"
import { getImagenesPorProducto } from "../../service/imagenApi"



export default function Listado() {
    const [recomendados, setRecomendados] = useState([])
    const [portadas, setPortadas] = useState([])
<<<<<<< HEAD
    const imagenDummy = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fdummyimage.com%2F&psig=AOvVaw15z8_2NnfqZjrLR59929kC&ust=1669243062702000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCJCN2ZLtwvsCFQAAAAAdAAAAABAD"
=======
>>>>>>> daa76d218e2402f4e2ed7e8a758ce90f18001634

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
<<<<<<< HEAD
                .then(data => {
                    let imagen =  (data[0] !== undefined) ? data[0].url : imagenDummy
                    setPortadas(oldArray => [...oldArray, imagen])
                })
=======
                .then(data => setPortadas(oldArray => [...oldArray, data[0]]))
>>>>>>> daa76d218e2402f4e2ed7e8a758ce90f18001634
                .catch(() => {})
        }
        )
    }, [recomendados])

    return (
        <>
<<<<<<< HEAD
        <div className={style.container}>
            <h2> Recomendaciones </h2>
            <div className={style.tarjetaListadoContainer}>
                {(recomendados.length !== 0 && portadas.length !== 0) ? recomendados.map((producto, index) => <Card key={producto.id} id={producto.id} imagen={portadas[index]} category={producto.categoria.titulo} name={producto.nombre} title={producto.titulo} location={producto.ciudad.nombre} description={producto.descripcion} calificacion={producto.calificacion}/>) : <></>}
            </div>
        </div>
=======
            <div className={style.tarjetaListadoContainer}>
                {(recomendados.length !== 0 && portadas.length !== 0) ? recomendados.map((producto, index) => <Card key={producto.id} id={producto.id} imagen={portadas[index]} category={producto.categoria.titulo} name={producto.nombre} title={producto.titulo} location={producto.ciudad.nombre} description={producto.descripcion}/>) : <></>}
            </div>
>>>>>>> daa76d218e2402f4e2ed7e8a758ce90f18001634
        </>
    )
}
