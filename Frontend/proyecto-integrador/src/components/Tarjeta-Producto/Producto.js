import Card from "./TarjetaProducto"
import { useEffect, useState } from "react"
import { getProducto } from "../../service/productoApi"
import { getImagenesPorProducto } from "../../service/imagenApi" 
import { useParams} from "react-router-dom";

export default function Producto(){
    let { id } = useParams();

    // const [producto, setProducto] = useState({})
    // const [imagenes, setImagenes] = useState([])

    
    const imagenes = [
        {
            id: 1,
            titulo: "desayuno",
            url: "https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/partnerimages/10/20/1020990116.jpeg",
        },{
            id: 2,
            titulo: "desayuno",
            url: "https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/partnerimages/10/20/1020990116.jpeg",
        },{
            id: 3,
            titulo: "desayuno",
            url: "https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/partnerimages/10/20/1020990116.jpeg",
        },{
            id: 4,
            titulo: "desayuno",
            url: "https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/partnerimages/10/20/1020990116.jpeg",
        },{
            id: 5,
            titulo: "desayuno",
            url: "https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/partnerimages/10/20/1020990116.jpeg",
        },{
            id: 6,
            titulo: "desayuno",
            url: "https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/partnerimages/10/20/1020990116.jpeg",
        },{
            id: 7,
            titulo: "desayuno",
            url: "https://imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_1300,q_auto,w_2000/partnerimages/10/20/1020990116.jpeg",
        } 
    ]

    const producto = {
        id: 1,
        nombre: "NH Buenos Aires 9 de julio",
        calificacion: 9,
        titulo: "Privilegiada ubicación en el centro de la ciudad",
        descripcion: "El NH Buenos Aires 9 de Julio se caracteriza por su privilegiada ubicación en una de las principales avenidas de la capital argentina. Cada mañana se sirve el desayuno en el NH Buenos Aires 9 de Julio.",
        categoria: {
            id: 3,
            titulo: "Bed and breakfast",
            descripcion: "Tipo de alojamiento en una residencia privada de pocas habitaciones. Familiar y hogareño.",
            imagen: "https://images.unsplash.com/photo-1618111415065-c20b4e1afd41?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80"
        },
        ciudad: {
            id: 1,
            pais: "Argentina",
            nombre: "Buenos Aires"
        },
        caracteristica: [
            {
                id: 4,
                nombre: "WiFi",
                descripcion: "Conectividad WiFi disponible."
            },
            {
                id: 12,
                nombre: "Bar",
                descripcion: "bar en el comedor del hotel"
            },
            {
                id: 13,
                nombre: "Pileta",
                descripcion: "Pileta exterior"
            },
            {
                id: 3,
                nombre: "Desayuno",
                descripcion: "Desayuno incluído con medialunas, jugo de naranja, café, entre otros."
            },
            {
                id: 14,
                nombre: "Solarium",
                descripcion: "Espacio al aire libre"
            },
            {
                id: 2,
                nombre: "Televisor",
                descripcion: "Televisor dentro de la habitación."
            },
            {
                id: 1,
                nombre: "Artículos de tocador",
                descripcion: "Shampoo, acondicionador, jabón, crema corporal."
            },
            {
                id: 6,
                nombre: "Gimnasio",
                descripcion: "Centro de acondicionamiento físico para huéspedes."
            },
            {
                id: 9,
                nombre: "Ropa de cama",
                descripcion: "Sábanas y acolchados disponibles."
            },
            {
                id: 11,
                nombre: "Aire acondicionado",
                descripcion: "Aire acondicionado en la habitación."
            }
        ],
        seguridad: [
            {
                id: 5,
                politica: "Recepcionista disponible 24hs"
            },
            {
                id: 1,
                politica: "Protocolo de distanciamiento social"
            }
        ],
        cancelacion: [
            {
                id: 1,
                politica: "Cancelar con 2 semanas de anticipación para recibir el reintegro de su seña."
            }
        ],
        normas: [
            {
                id: 3,
                norma: "Check in a las 12:00hs"
            },
            {
                id: 8,
                norma: "Check out a las 09:00hs"
            },
            {
                id: 14,
                norma: "No fumar en interiores"
            },
            {
                id: 17,
                norma: "No hacer ruido después de las 22:00hs"
            }
        ]
    }

        // useEffect( () => {
    //     getProducto(id).then( (data) => {
    //         console.log(data);
    //         setProducto(data);
    //     })
    // }, [id])
    
    // useEffect( () => {
    //     getImagenesPorProducto(id).then( (data) => {
    //         console.log(data);
    //         setImagenes(data);
    //     })
    // }, [id])

    return (
        <>
        {/*Corregir debido a que ya no son strings*/}
            {(imagenes.length !== 0 && producto !== undefined)? <Card key={producto.id} imagen={imagenes} category={producto.categoria.titulo} name={producto.nombre} title={producto.titulo} location={producto.ciudad.nombre} description={producto.descripcion} calificacion={producto.calificacion} caracteristicas={producto.caracteristica} politicas={producto.politicas} normasDeLaCasa = {producto.normas} saludSeguridad = {producto.seguridad} politicaDeCancelacion = {producto.cancelacion} /> : <></>}
        </>
    )
}