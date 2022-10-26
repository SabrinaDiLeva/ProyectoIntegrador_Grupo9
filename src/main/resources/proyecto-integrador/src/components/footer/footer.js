import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { solid, regular, brands, icon } from '@fortawesome/fontawesome-svg-core/import.macro';

import './footer.css';

function Footer() {

    return (
        <div className='footer-block'>
            <div className='footer-block2'>
                <div className='footer-text'>
                    <p> ©2022 Digital Booking </p>


                </div>

                    <div className='footer-icons'>
                        <a href='#'><FontAwesomeIcon icon={brands('twitter')} /></a>
                        <a href='#'> <FontAwesomeIcon icon={brands('facebook')} /></a>
                        <a href='#'> <FontAwesomeIcon icon={brands('instagram')} /></a>
                        <a href='#'><FontAwesomeIcon icon={brands('linkedin')} /></a>

                    </div>
            </div>
        </div>
    )
}

export default Footer;