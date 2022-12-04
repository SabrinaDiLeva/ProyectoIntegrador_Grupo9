import style from "./galeria.module.css"
import Imagen from "../../ImagenWrapper/Imagen"

export default function Galeria(props) {
    return (

    <div className={style.contenedorImagenes}>
    <button className={style.contenedorImagenesAll} onClick={props.handleToggle}>
        <div className={style.contenedorImgIzquierda}>
            <Imagen src={props.imagenes[0].url} alt={props.imagenes[0].titulo} />
        </div>
        <span className={style.contenedorImgDerecha}>
                {props.imagenes.map((img, index) => {
                    return (index !== 0 && index < 5) ? <div className={style.subContenedorImgDerecha}><Imagen className={style.imagenDerecha} src={img.url} alt={img.titulo} /></div> : ''
                })}
        </span>
    </button>
</div>
    )

}