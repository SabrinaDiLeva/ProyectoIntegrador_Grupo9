import React from 'react';
import style from './navBar.module.css'
import Burger from './Burger';
import { Link, Routes, Route } from "react-router-dom";
import { sessionClosed } from '../../../hooks/sessionStorage';
import Perfil from './Perfil';
import Social from '../../Footer/Social';

const NavBar = (props) => {

    const session = sessionStorage.getItem('sessionIniciada')

    if (session) {
        var loggedUser = {
            mail: JSON.parse(session)[0].mail,
            password: JSON.parse(session)[0].password,
            //name: `${JSON.parse(session)[0].nombre.charAt(0).toUpperCase()}${JSON.parse(session)[0].nombre.slice(1)}`,
            //lastname: `${JSON.parse(session)[0].apellido.charAt(0).toUpperCase()}${JSON.parse(session)[0].apellido.slice(1)}`,
            name: "Marcos",
            lastname: "Ferro"
        }
    }

    return (
        <>
            <nav className={`${ !props.hide ? style.showMenu : style.hideMenu}`}>
                <div className={`${style.menu}`}>
                    <ul className={style.menuNav}>
                        <div className={style.burger}>
                            <Burger open={!props.hide} handleToggle={props.handleToggle} />
                        </div>
                        <li className={style.menuTitle}>
                            {loggedUser ?
                                <>
                                    <div className={style.usuario}>
                                        <Perfil user={loggedUser} />
                                    </div>
                                </> : <>
                                    <span className={style.title}>Menu</span>
                                </>

                            }
                        </li>

                        <Routes>
                            {!loggedUser ?
                                <>
                                    <Route path='/*' element={<>
                                        <li className={style.option}><Link onClick={props.closeMenu} exact to='/iniciar_sesion'>Iniciar Sesion</Link></li>
                                        <li className={style.option}><Link onClick={props.closeMenu} exact to='/registrarse'>Registrarse</Link></li>
                                    </>} />

                                    <Route path='/iniciar_sesion' element={<>
                                        <li className={style.option}><Link className={style.link} onClick={props.closeMenu} exact to='/registrarse'>Registrarse</Link></li>
                                    </>} />

                                    <Route path='/registrarse' element={<>
                                        <li className={style.option}><Link className={style.link} onClick={props.closeMenu} exact to='/iniciar_sesion'>Iniciar Sesion</Link></li>
                                    </>} />
                                </>
                                :
                                <Route path='/*' element={<>
                                    <li className={style.option} onClick={sessionClosed}> <Link className={style.link} onClick={props.closeMenu} exact to='/'>Cerrar Sesion</Link></li>
                                </>} />
                            }
                        </Routes>
                    </ul>
                    <div className={style.social}>
                        <Social/>
                    </div>
                </div>
            </nav>
        </>
    )
}

export default NavBar;