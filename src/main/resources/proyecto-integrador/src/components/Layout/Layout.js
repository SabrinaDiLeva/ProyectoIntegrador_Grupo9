import {Outlet} from "react-router-dom"
import SeccionHeader from '../Header/SeccionHeader';
import Buscador from '../Bloque-buscador/Buscador';
import Body from '../Body/Body';
export default function Layout() {

    return (
        <>
        <Body>
           <SeccionHeader/> 
           <Buscador/> 
        </Body>
        <Outlet/>
        </>
    )
}