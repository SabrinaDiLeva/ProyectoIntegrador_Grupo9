import axios from "axios";
import BASEURL from './EndPoint';

export const getProducto = async (id) => {
    const endpoint = `${BASEURL}/producto/${id}`
    const response = await axios.get(endpoint);
    return response.data
}

export const getProductosPorCategoria = async (categoria) => {
    const endpoint = `${BASEURL}/producto/categoria/${categoria}`
    const response = await axios.get(endpoint);
    return response.data
}

export const getProductosRandom = async () => {
    const endpoint = `${BASEURL}/producto/random`
    const response = await axios.get(endpoint);
    return response.data
}

/*
export const getPokemonByPagina = async( pagina ) => {
    const limite = 20
    const offset = limite * ( pagina - 1 )
    const endpoint = `${BASEURL}/producto/pokemon?limit=${limite}&offset=${offset}`;
    const response = await axios.get(endpoint);
    return response.data.results
}
*/