import axios from "axios";

const baseUrl = "http://3.14.41.232:8080/categoria"

export const getCategorias = async() => {
    const endpoint = `${baseUrl}/`
    const response = await axios.get(endpoint);
    return response.data
}