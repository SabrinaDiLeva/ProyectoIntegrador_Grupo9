import {Outlet} from "react-router-dom"
import SeccionHeader from '../Header/SeccionHeader';
import Body from '../Body/Body';
export default function Layout() {

    return (
        <>
        <Body>
           <SeccionHeader/> 
        </Body>
        <Outlet/>
        </>
    )
}