import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { brands } from '@fortawesome/fontawesome-svg-core/import.macro';
import style from './Footer.module.css';

function Footer() {
<<<<<<< HEAD

=======
>>>>>>> daa76d218e2402f4e2ed7e8a758ce90f18001634
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

<<<<<<< HEAD
export default Footer;
=======
export default Footer
>>>>>>> daa76d218e2402f4e2ed7e8a758ce90f18001634
