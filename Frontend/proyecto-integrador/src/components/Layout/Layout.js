import {Outlet} from "react-router-dom"
import SeccionHeader from '../Header/SeccionHeader';
import Body from '../Body/Body';
import Footer from "../Footer/Footer";

export default function Layout() {

    return (
        <>
        <SeccionHeader/>
        <Body>
            <Outlet/>
        </Body>
        <Footer/>
        </>
    )
}