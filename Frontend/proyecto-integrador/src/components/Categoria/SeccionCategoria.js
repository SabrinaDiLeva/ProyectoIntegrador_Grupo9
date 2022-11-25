import Categoria from "./Categoria"
import style from './SeccionCategoria.module.css'
import { useEffect, useState } from "react"
import { getCategorias } from "../../service/categoriaApi"
import { getProductosPorCategoria } from "../../service/productoApi"


export default function SeccionCategoria() {
    const [categorias, setCategorias] = useState([])
    const [cantidadPorCategoria, setCantidadPorCategoria] = useState([])

    useEffect(() => {
        if (categorias.length === 0) {
            getCategorias().then((data) => {
                console.log(data)
                setCategorias(data);
            })

        }
    }, [])
    
    useEffect(() => {
            categorias.forEach(categoria => 
                getProductosPorCategoria(categoria.id)
                .then(data => {
                    setCantidadPorCategoria(oldArray => [...oldArray, data.length])
                })
                .catch(() => 0)
            )

    }, [categorias])

    return (
        <>
            <div className={style.body}>
                <h1 className={style.titulo}>Busca tu tipo de alojamiento</h1>
                <div className={style.tarjetaContainer}>
                    {categorias.map((categoria, index) => <Categoria key={categoria.id} imagen={categoria.imagen} titulo={categoria.titulo} caption={`${cantidadPorCategoria[index]} resultados encontrados`} />)}
                </div>
            </div>
        </>
    )
}