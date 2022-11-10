import axios from "axios";

const baseUrl = "http://localhost:8080/imagen"

export const getImagenesPorProducto = async(id) => {
    const endpoint = `${baseUrl}/producto/${id}`
    const response = await axios.get(endpoint);
    return response.data
}