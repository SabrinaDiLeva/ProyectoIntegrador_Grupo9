import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { solid, regular, brands, icon } from '@fortawesome/fontawesome-svg-core/import.macro';
import style from './Footer.module.css';

function Footer() {

    return (
        <>
        <div className={style.footerBlock}>
            <div className={style.footerBlock2}>
                <span className={style.footerText}>
                    <p>2022 Digital Booking </p>
                    <small>©</small>
                </span>

                <span className={style.footerIcons}>
                    <a className={style.icono} href='/'><FontAwesomeIcon icon={brands('twitter')}/></a>
                    <a className={style.icono} href='/'><FontAwesomeIcon icon={brands('facebook')}/></a>
                    <a className={style.icono} href='/'><FontAwesomeIcon icon={brands('instagram')}/></a>
                    <a className={style.icono} href='/'><FontAwesomeIcon icon={brands('linkedin')}/></a>
                </span>
            </div>
        </div>
        </>
    )
}

export default Footer;