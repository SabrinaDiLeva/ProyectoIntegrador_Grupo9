import axios from "axios";
import BASEURL from './EndPoint';

export const getCategorias = async() => {
    const endpoint = `${BASEURL}/categoria`
    const response = await axios.get(endpoint);
    return response.data
}