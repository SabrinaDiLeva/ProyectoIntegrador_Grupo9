import React, { useState, useEffect } from 'react';
import style from './Header.module.css'
import NavBar from './minicomponents/navBar';
import Logo from './minicomponents/Logo';
import Slogan from './minicomponents/Slogan';
import Burger from './minicomponents/Burger';

const session = localStorage.getItem('jwt')

const Header = (props) => {
  const [navbarOpen, setNavbarOpen] = useState(false)
  const [scroll, setScroll] = useState(true)

  if (session !== null) {

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
  const handleToggle = () => {
    setNavbarOpen(!navbarOpen)
  }

  const closeMenu = () => {
    setScroll(true)
    setNavbarOpen(false)
  }

  useEffect(() => {
    function handleResize() {
      setNavbarOpen(window.innerWidth > 424 ? false : navbarOpen)
    }
    window.addEventListener('resize', handleResize)
  })

  useEffect(() => {
      setScroll(window.innerWidth > 424 ? true : !navbarOpen)
  }, [navbarOpen])

  useEffect(() => {
    var element = document.getElementById("body");
    if (!element) {
      return
    }
    console.log(`SCROLL: ${scroll}`)
    element.style.overflowY = scroll ? 'unset' : 'hidden';
    //element.style.height = scroll ? '89%' : 'unset';
  }, [scroll])

  return (
    <>
      <header className={style.header}>
        <div className={style.subHeaderIzquierda}>
          <a href='/' className={style.home}>
            <Logo />
            <Slogan />
          </a>
        </div>
        <div className={`${style.subHeaderDerecha} ${navbarOpen ? style.cover : style.contain} `}>
          <div className={style.burger}>
            <Burger open={navbarOpen} handleToggle={handleToggle} />
          </div>
          <NavBar hide={!navbarOpen} handleToggle={handleToggle} closeMenu={closeMenu} />
        </div>
      </header>
    </>
  );
};

export default Header;