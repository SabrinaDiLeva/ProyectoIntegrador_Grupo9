import React, { useState }from 'react';
import style from "./tarjetaProducto.module.css";
import { Carousel } from 'react-responsive-carousel';
import "react-responsive-carousel/lib/styles/carousel.min.css"; // requires a loader
import { MdClose } from "react-icons/md"

const Carrousel = (props) => {
    const [carrouselOpen, setcarrouselOpen] = useState(false)

    const handleToggle = () => {
      setcarrouselOpen(!carrouselOpen)
    }

    return (
        <>
        <Carousel
                autoPlay
                infiniteLoop
                showArrows={window.innerWidth < 992 ? false : true}
                showThumbs={window.innerWidth < 992 ? false : true}
                showIndicators={false}
                className={style.carrousel}
            >
                {props.imagenes.map( (img, index) => {
                    return <>
                        <div className={style.carrouselContainer}>
                            <img className={style.imagenCarrousel} src={img.url} alt=""></img>
                        </div>
                    </> 
                })}

            </Carousel>
        </>
    )
}

export default Carrousel;