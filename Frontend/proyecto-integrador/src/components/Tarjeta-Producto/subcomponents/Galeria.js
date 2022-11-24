import style from "./galeria.module.css"
import Imagen from "../../ImagenWrapper/Imagen"

export default function Galeria(props) {
    return (

    <div className={style.contenedorImagenes}>
    <button className={style.contenedorImagenesAll} onClick={props.handleToggle}>
        <span className={style.contenedorImgIzquierda}>
            <Imagen src={props.imagenes[0].url} alt={props.imagenes[0].titulo} />
        </span>
        <span className={style.contenedorImgDerecha}>
            <span className={style.subContenedorImgDerecha}>
                {props.imagenes.map((img, index) => {
                    return index !== 0 ? <Imagen className={style.imagenDerecha} src={img.url} alt={img.titulo} /> : ''
                })}
            </span>
        </span>
    </button>
</div>
    )

}