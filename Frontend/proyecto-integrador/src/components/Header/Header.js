import React from 'react';
import style from './Header.module.css'
import data from './headerInfo.json'
import Logo from '../ui/logo.png'
import { Link, Routes, Route } from "react-router-dom";
import {sessionClosed} from '../../hooks/sessionStorage';
import NavBar from './navBar';

const session = sessionStorage.getItem('sessionIniciada')

const Header = (props) => {

  if(session){
    var loggedUser = {
      mail: JSON.parse(session)[0].mail,
      password: JSON.parse(session)[0].password,
      // name: `${JSON.parse(session)[0].nombre.charAt(0).toUpperCase()}${JSON.parse(session)[0].nombre.slice(1)}`,
      // apellido: `${JSON.parse(session)[0].apellido.charAt(0).toUpperCase()}${JSON.parse(session)[0].apellido.slice(1)}`,
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
                  <span className={style.avatar}>MF</span>
                    {/* {loggedUser ? `${loggedUser.name.charAt(0)} ${loggedUser.apellido.charAt(0)}` : '' } ESTO VA DENTRO DEL SPAN EN LUGAR DE MF*/}
                </div>
                <span className={style.perfilUsuario}>
              <a className={style.linkPerfil} href="/">
                <p className={style.saludo}>Hola,</p>
                <p className={style.saludo2}>{loggedUser ? loggedUser.mail.split("@")[0] : ''}</p>
                {/* {loggedUser ? `${loggedUser.name} ${loggedUser.apellido}` : '' } ESTO VA DENTRO DEL P EN LUGAR DE MF  */}
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