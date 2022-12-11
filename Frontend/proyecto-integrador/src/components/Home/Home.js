import SeccionCategoria from '../Categoria/SeccionCategoria';
import Listado from '../Listado/Listado';
import Buscador from '../Bloque-buscador/Buscador';
import { getProductosRandom, getProductosPorCategoria } from "../../service/productoApi"
import { useEffect, useState } from "react"

export default function Home() {
    const [categoria, setCategoria] = useState('random')
    const [productos, setProductos] = useState([])

    const filterCategoria = (categoria) => {
        setCategoria(categoria)
    }

    const randomProducts = () => {
        if (productos.length === 0) {
            getProductosRandom().then((data) => setProductos(data))
        }
    }

    useEffect(() => {
        if( categoria === 'random'){
            randomProducts()
        }else{
            getProductosPorCategoria(categoria).then((data) => setProductos(data))
        }
    }, [categoria])


    return (
        <>
            <Buscador />
            <SeccionCategoria filter={filterCategoria}/>
            <Listado productos={productos} />
        </>)
}