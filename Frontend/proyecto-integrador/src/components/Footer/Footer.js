import React from 'react';
import style from './Footer.module.css';
import Social from './Social';

export default function Footer() {
    return (
        <>
        <div className={style.footerBlock}>
                <span className={style.footerText}>
                    <p>2022 Digital Booking </p>
                    <small>©</small>
                </span>

                <Social/>

        </div>
        </>
    )
}