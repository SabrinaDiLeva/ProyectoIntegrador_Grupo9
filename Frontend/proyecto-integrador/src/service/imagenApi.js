import axios from "axios";

const baseUrl = "http://3.14.41.232:8080/imagen"

export const getImagenesPorProducto = async(id) => {
    const endpoint = `${baseUrl}/producto/${id}`
    const response = await axios.get(endpoint);
    return response.data
}