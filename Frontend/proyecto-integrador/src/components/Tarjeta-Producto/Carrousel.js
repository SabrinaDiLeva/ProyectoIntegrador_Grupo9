import React, { useState } from 'react';
import style from "./carrousel.module.css";
import { Carousel } from 'react-responsive-carousel';
import "react-responsive-carousel/lib/styles/carousel.min.css"; // requires a loader
import Imagen from "../ImagenWrapper/Imagen"
import { MdClose } from "react-icons/md"

const Carrousel = (props) => {

    return (
        <>
            <div className={style.carrouselContainer}>
                <button className={style.carrouselButton} onClick={props.handleToggle}>
                    <MdClose className={style.menuCerrado} />
                </button>
                <Carousel
                    autoPlay
                    infiniteLoop
                    showArrows={window.innerWidth < 420 ? false : true}
                    showThumbs={window.innerWidth < 420 ? false : true}
                    className={style.carrousel}
                >
                    {props.imagenes.map((img, index) => {
                        return <>
                            <div className={style.carrouselContainer}>
                                <Imagen src={img.url} alt={img.titulo} />
                            </div>
                        </>
                    })}

                </Carousel>
            </div>
        </>
    )
}

export default Carrousel;