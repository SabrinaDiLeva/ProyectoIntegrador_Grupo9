import axios from "axios";

const baseUrl = "http://localhost:8080/ciudad" // o localhost:8080

export const getCiudades= async() => {
    const endpoint = `${baseUrl}/`
    const response = await axios.get(endpoint);
    return response.data
}