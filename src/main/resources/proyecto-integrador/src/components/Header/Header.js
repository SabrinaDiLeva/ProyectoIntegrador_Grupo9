import React, {useContext } from "react";
// import Logo from "./minicomponents/Logo";
import style from './Header.module.css'
import data from './headerInfo.json'
import Logo from '../ui/logo.png'
import { UserContext } from "../../hooks/UseContext";
import { Link, Routes, Route} from "react-router-dom";


const Header = (props) => {

  // usar session storage
  const loggedUser = useContext(UserContext);
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

          <div className={loggedUser ? style.sessionIniciada : style.iniciarSession}>
            <div className={style.usuarioSessionIniciada}>
                <div className={style.avatar}>MF</div>
              <span className={style.perfilUsuario}>
                <p className={style.saludo}>Hola,</p>
                <a className={style.linkPerfil} href="/">Marcos Ferro</a>
              </span>
                <button className={style.button} href="/">Cerrar Sesión</button>
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


