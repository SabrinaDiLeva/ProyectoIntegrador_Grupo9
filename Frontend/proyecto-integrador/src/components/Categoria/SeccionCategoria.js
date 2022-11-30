import Categoria from "./Categoria"
<<<<<<< HEAD
import style from './SeccionCategoria.module.css'
=======
import style from './Categoria.module.css'
>>>>>>> daa76d218e2402f4e2ed7e8a758ce90f18001634
import { useEffect, useState } from "react"
import { getCategorias } from "../../service/categoriaApi"
import { getProductosPorCategoria } from "../../service/productoApi"


export default function SeccionCategoria() {
    const [categorias, setCategorias] = useState([])
    const [cantidadPorCategoria, setCantidadPorCategoria] = useState([])

    useEffect(() => {
        if (categorias.length === 0) {
            getCategorias().then((data) => {
<<<<<<< HEAD
                console.log(data)
=======
>>>>>>> daa76d218e2402f4e2ed7e8a758ce90f18001634
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
<<<<<<< HEAD
                <h1 className={style.titulo}>Busca tu tipo de alojamiento</h1>
=======
                <h1 className={style.titulo}>Busca tu tipo de Alojamiento</h1>
>>>>>>> daa76d218e2402f4e2ed7e8a758ce90f18001634
                <div className={style.tarjetaContainer}>
                    {categorias.map((categoria, index) => <Categoria key={categoria.id} imagen={categoria.imagen} titulo={categoria.titulo} caption={`${cantidadPorCategoria[index]} resultados encontrados`} />)}
                </div>
            </div>
        </>
    )
}