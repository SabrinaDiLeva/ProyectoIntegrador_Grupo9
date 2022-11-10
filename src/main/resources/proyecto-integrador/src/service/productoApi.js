import axios from "axios";

const baseUrl = "http://localhost:8080/producto"

export const getProducto= async( id ) => {
    const endpoint = `${baseUrl}/${id}`
    const response = await axios.get(endpoint);
    return response.data
}

export const getProductosPorCategoria = async(id) => {
    const endpoint = `${baseUrl}/categoria/${id}`
    const response = await axios.get(endpoint);
    return response.data
}
export const getProductosRandom = async() => {
    const endpoint = `${baseUrl}/random`
    const response = await axios.get(endpoint);
    return response.data
}

/*
export const getPokemonByPagina = async( pagina ) => {
    const limite = 20
    const offset = limite * ( pagina - 1 )
    const endpoint = `${baseUrl}/pokemon?limit=${limite}&offset=${offset}`;
    const response = await axios.get(endpoint);
    return response.data.results
}
*/