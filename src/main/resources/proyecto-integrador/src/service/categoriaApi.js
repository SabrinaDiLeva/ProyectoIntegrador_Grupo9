import axios from "axios";

const baseUrl = "http://localhost:8080/categoria"

export const getCategorias = async() => {
    const endpoint = `${baseUrl}/`
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