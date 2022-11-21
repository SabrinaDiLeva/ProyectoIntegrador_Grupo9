import axios from "axios";

const baseUrl = "http://localhost:8080/categoria" // o 3.14.41.232:8080

export const getCategorias = async() => {
    const endpoint = `${baseUrl}/`
    const response = await axios.get(endpoint);
    return response.data
}