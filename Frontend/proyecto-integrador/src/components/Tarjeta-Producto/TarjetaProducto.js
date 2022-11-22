import style from "./tarjetaProducto.module.css";
import Titulo from "./subcomponents/Titulo"
import Politicas from "./subcomponents/Politicas"
import { DateRange } from 'react-date-range';
import { Icons } from '../ui/icons';
import { Carousel } from 'react-responsive-carousel';
import "react-responsive-carousel/lib/styles/carousel.min.css"; // requires a loader


export default function TarjetaProducto(props) {
    const totalStars = 5;
    const activeStars = ( props.calificacion * totalStars ) / 10;

    return(
        <>
        <div className={style.container}>
           <Titulo category={props.category} name={props.name} /> 

            <div className={style.subHeader}>
                <span className={style.subHeaderIzquierda}>
                    <h3>{props.location}</h3>
                    <p>Cerca del centro</p>
                </span>
                <span className={style.subHeaderDerecha}>
                    <span className={style.calificacion}>
                        {[...new Array(totalStars)].map((arr, index) => {
                            return index < activeStars ? Icons.estrellaLlena : Icons.estrellaVacia;
                        })}
                    </span>
                    <p>{activeStars.toFixed(0)}</p>
                </span>
            </div>

            <div className={style.contenedorImagenes}>
                <button className={style.contenedorImagenesAll} onClick>
                    <span className={style.contenedorImgIzquierda}>
                        <img className={style.imagenIzquierda} src={props.imagen[0].url} alt="imagenProductoIzquierda"></img>
                    </span>

                    <span className={style.contenedorImgDerecha}>
                        <span className={style.subContenedorImgDerecha}>
                            {props.imagen.map( (img, index) => {
                                return index !== 0 ? <img className={style.imagenDerecha} src={img.url} alt="imagenProductoDerecha"></img> : ''
                            })}
                        </span>
                    </span>
                </button>   
            </div>

            <Carousel
                autoPlay
                infiniteLoop
                showArrows={window.innerWidth < 992 ? false : true}
                showThumbs={window.innerWidth < 992 ? false : true}
                showIndicators={false}
                className={style.carrousel}
            >
                {props.imagen.map( (img, index) => {
                    return <>
                        <div className={style.carrouselContainer}>
                            <img className={style.imagenDerecha} src={img} alt="imagenProductoDerecha"></img>
                        </div>
                    </> 
                })}

            </Carousel>
            
            <div className={style.descriptionContainer}>
                <h2>{props.title}</h2>
                <p>{props.description}</p>
            </div>   

            <div className={style.caracteristicasContainer}>
                <h2>¿Que ofrece este lugar?</h2>
                <span className={style.caracteristicaItms}>
                    {props.caracteristicas.map( (caracteristica) => {
                        return <p>{Icons[caracteristica.nombre]} {caracteristica.nombre}</p>
                    })}
                </span>
            </div>

            <div className={style.calendarWrap}>
                <span className={style.calendarContainer}>
                    <h2>Fechas disponibles</h2>
                    <DateRange 
                        // onChange={item => setRange([item.selection])}
                        editableDateInputs={false}
                        moveRangeOnFirstSelection={false}
                        // ranges={range}
                        months={window.innerWidth > 767 ? 2 : 1}
                        direction='horizontal'
                        className={style.calendarElement}
                    />
                </span>
                <span className={style.iniciarReservaContainer}>
                    <h3>Agrega tus fechas de viaje para obtener precios exactos</h3>
                    <button className={style.botonBuscar}>Iniciar reserva</button>
                </span>
            </div>

            <Politicas normasDeLaCasa={props.normasDeLaCasa} saludSeguridad={props.saludSeguridad} politicaDeCancelacion={props.politicaDeCancelacion} />

        </div>
        </>
    )
}