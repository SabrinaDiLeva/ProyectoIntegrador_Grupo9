import React from 'react';
import style from './Header.module.css'
import data from './headerInfo.json'
import Logo from '../ui/logo.png'
import { Link, Routes, Route } from "react-router-dom";
import {sessionClosed} from '../../hooks/sessionStorage';
import NavBar from './navBar';

const session = localStorage.getItem('jwt')

const Header = (props) => {

  if(session !== null){

    let base64Url = session.split('.')[1];
    //let base64 = base64Url.replace('-', '+').replace('_', '/');
    const decode = atob(base64Url);

    var loggedUser = {
      nameLetter: `${JSON.parse(decode).name[0].toUpperCase()}`,
      lastNameLetter: `${JSON.parse(decode).lastName[0].toUpperCase()}`,
      name: `${JSON.parse(decode).name[0].toUpperCase()}${JSON.parse(decode).name.slice(1)}`,
      lastName: `${JSON.parse(decode).lastName[0].toUpperCase()}${JSON.parse(decode).lastName.slice(1)}`
    }
  }

  const randomSloganIndex = Math.round(Math.random() * 3);

  return (
    <>
      <header className={style.header}>
        <div className={style.headerContainer}>
        
          <div className={style.headerLogo}>
            <a className={style.link} href='/'>
              <div className={style.LogoSlogan}>
                <img className={style.images} src={Logo} alt={props.nombre}/>
                <span className={style.slogan}> {data[randomSloganIndex].slogan} </span>
              {/* termina logoSlogan */}
              </div> 
            </a>
          {/* termina headerLogo */}
          </div>
          <NavBar/>
          
          <div className={loggedUser ? style.sessionIniciada : style.iniciarSession}>
            <div className={style.usuarioSessionIniciada}>
                <div className={style.avatarContainer}>
                  <span className={style.avatar}>{loggedUser ? `${loggedUser.nameLetter}${loggedUser.lastNameLetter}` : '' }</span>
                </div>
                <span className={style.perfilUsuario}>
              <a className={style.linkPerfil} href="/">
                <p className={style.saludo}>Hola, {loggedUser ? `${loggedUser.name} ${loggedUser.lastName}` : '' }</p>
              </a>
              </span>
              <button className={style.button} href="/" onClick={sessionClosed}>Cerrar Sesión</button>
            {/* cierra usuarioSessionIniciada */}
            </div>
            
            <div className={style.usuarioIniciarSession}>
              <Routes>
                <Route path='/*' element={<>
                  <button id={style.buttonLogin} className={style.button} type="button"><Link to='/iniciar_sesion'>Iniciar Sesion</Link></button>
                  <button id={style.buttonRegister} className={style.button} type="button"><Link to='/registrarse'>Registrarse</Link></button>
                </>}/> 

                <Route path='/iniciar_sesion' element={<>
                  <button id={style.buttonRegister} className={style.button} type="button"><Link to='/registrarse'>Registrarse</Link></button>
                </>}/> 
                
                <Route path='/registrarse' element={<>
                  <button id={style.buttonLogin} className={style.button} type="button"><Link to='/iniciar_sesion'>Iniciar Sesion</Link></button>
                </>}/>
              </Routes> 
            {/* cierra usuarioIniciarSession */}
            </div>
          </div>
        {/* cierra headerContainer */}
        </div>  
      {/* cierra header */}
      </header>
    </>
  );
};

export default Header;