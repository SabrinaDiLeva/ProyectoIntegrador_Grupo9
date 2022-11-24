import React, { useState }from 'react';
import style from './Header.module.css'
import { Link, Routes, Route} from "react-router-dom";
import {sessionClosed} from '../../hooks/sessionStorage';
import { MdClose } from "react-icons/md"
import { FiMenu } from "react-icons/fi"

const NavBar = (props) => {

      
  const [navbarOpen, setNavbarOpen] = useState(false)

  const handleToggle = () => {
    setNavbarOpen(!navbarOpen)
  }

  const closeMenu = () => {
    setNavbarOpen(false)
  }

    return (
        <>
            <nav className={style.navBar}>
                <button className={style.hamburguesaButton} onClick={handleToggle}>
                    {navbarOpen ? (
                    <MdClose className={style.menuCerrado} />) : (
                    <FiMenu className={style.menuAbierto} />)
                    }
                </button>
                <ul className= {`${style.menuNav} ${navbarOpen ? style.showMenu : ''}`}>
                    <li>Menu</li>
                    <Routes>
                        <Route path='/*' element={<>
                            <li><Link onClick={() => closeMenu()} exact to='/iniciar_sesion'>Iniciar Sesion</Link></li>
                            <li><Link onClick={() => closeMenu()} exact to='/registrarse'>Registrarse</Link></li>
                        </>}/> 

                        <Route path='/iniciar_sesion' element={<>
                            <li><Link onClick={() => closeMenu()} exact to='/registrarse'>Registrarse</Link></li>
                        </>}/> 

                        <Route path='/registrarse' element={<>
                            <li><Link onClick={() => closeMenu()} exact to='/iniciar_sesion'>Iniciar Sesion</Link></li>
                        </>}/>
                    </Routes> 
                </ul>
            </nav>
        </>
    )
}

export default NavBar;