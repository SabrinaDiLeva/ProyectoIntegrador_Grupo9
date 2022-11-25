import axios from "axios";
import BASEURL from './EndPoint';

export const getCiudades= async() => {
    const endpoint = `${BASEURL}/ciudad/`
    const response = await axios.get(endpoint);
    return response.data
}