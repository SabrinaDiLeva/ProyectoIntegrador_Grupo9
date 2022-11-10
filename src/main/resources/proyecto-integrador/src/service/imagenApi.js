import axios from "axios";

const baseUrl = "http://localhost:8080/imagen"

export const getImagenesPorProducto = async(id) => {
    const endpoint = `${baseUrl}/producto/${id}`
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