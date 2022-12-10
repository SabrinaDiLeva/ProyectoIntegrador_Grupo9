import React, { useState, useEffect } from 'react';
import style from './Header.module.css'
import NavBar from './minicomponents/navBar';
import Logo from './minicomponents/Logo';
import Slogan from './minicomponents/Slogan';
import Burger from './minicomponents/Burger';


const Header = (props) => {
    const [navbarOpen, setNavbarOpen] = useState(false)
    const [scroll, setScroll] = useState(true)

    const handleToggle = () => {
        setNavbarOpen(!navbarOpen)
    }

    const closeMenu = () => {
      setNavbarOpen(false)
    }

    useEffect( () => {
      function handleResize() {
          setNavbarOpen(window.innerWidth > 424? false : navbarOpen )
      }
      window.addEventListener('resize', handleResize)
  })
    useEffect( () => {
      setScroll(window.innerWidth > 424? true : navbarOpen)
  }, [navbarOpen])
    useEffect( () => {
      var element = document.getElementById("body");
      if (!element) {
        return
    }
    console.log(element)

    element.style.overflowY = scroll ? 'scroll' : 'hidden';
    element.style.height = scroll ? '89%' : 'unset';
  }, [scroll])

  return (
    <>
      <header className={style.header}>
        <div className={style.subHeaderIzquierda}>
          <a href='/' className={style.home}>
          <Logo/>
          <Slogan/>
          </a>
        </div>
        <div className={`${style.subHeaderDerecha} ${navbarOpen ? style.cover : style.contain} `}>
          <div className={style.burger}>
              <Burger open={navbarOpen} handleToggle={handleToggle} />
          </div>
          <NavBar hide={!navbarOpen} handleToggle={handleToggle} closeMenu={closeMenu}/>
        </div>
      </header>
    </>
  );
};

export default Header;