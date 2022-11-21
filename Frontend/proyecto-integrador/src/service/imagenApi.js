import axios from "axios";

const baseUrl = "http://localhost:8080/imagen" // o localhost:8080

export const getImagenesPorProducto = async(id) => {
    const endpoint = `${baseUrl}/producto/${id}`
    const response = await axios.get(endpoint);
    return response.data
}