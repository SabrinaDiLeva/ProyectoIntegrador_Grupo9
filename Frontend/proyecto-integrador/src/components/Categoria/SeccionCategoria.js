import Categoria from "./Categoria"
import style from './SeccionCategoria.module.css'
import { useEffect, useState } from "react"
import { getCategorias } from "../../service/categoriaApi"
import { getProductosPorCategoria } from "../../service/productoApi"


export default function SeccionCategoria(props) {
    const [categorias, setCategorias] = useState([])
    const [cantidadPorCategoria, setCantidadPorCategoria] = useState({})

    useEffect(() => {
        if (categorias.length === 0) {
            getCategorias().then((data) => {
                setCategorias(data);
            })

        }
    }, [])
    
    useEffect(() => {
            categorias.forEach(categoria => 
                getProductosPorCategoria(categoria.titulo)
                .then(data => {
                    let property = categoria.titulo
                    let value = data.length
                    let newValue = {}
                    newValue[property] = value
                    setCantidadPorCategoria( old => ({...old, ...newValue}))
                })
            )

            console.log(cantidadPorCategoria)
    }, [categorias])


    return (
        <>
            <div className={style.body}>
                <h1 className={style.titulo}>Busca tu tipo de Alojamiento</h1>
                <div className={style.tarjetaContainer}>
                    {categorias.map((categoria) => <Categoria key={categoria.id} filter={props.filter} imagen={categoria.imagen} titulo={categoria.titulo} caption={`${cantidadPorCategoria[categoria.titulo] ? cantidadPorCategoria[categoria.titulo] : 0} resultados encontrados`} />)}
                </div>
            </div>
        </>
    )
}