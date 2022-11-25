import axios from "axios";
import BASEURL from './EndPoint';

export const getImagenesPorProducto = async(id) => {
    const endpoint = `${BASEURL}/imagen/producto/${id}`
    const response = await axios.get(endpoint);
    return response.data
}