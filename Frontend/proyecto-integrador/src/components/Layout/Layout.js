import {Outlet} from "react-router-dom"
import SeccionHeader from '../Header/SeccionHeader';
import Body from '../Body/Body';
import Footer from "../Footer/Footer";
<<<<<<< HEAD
=======

>>>>>>> daa76d218e2402f4e2ed7e8a758ce90f18001634
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