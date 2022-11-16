import axios from "axios";

const baseUrl = "http://localhost:8080/categoria"

export const getCategorias = async() => {
    const endpoint = `${baseUrl}/`
    const response = await axios.get(endpoint);
    return response.data
}