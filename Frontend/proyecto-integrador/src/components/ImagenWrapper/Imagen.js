import style from "./imagen.module.css"

export default function Image(props) {
    return (
        <div className={style.container}>
           <img className={style.imagen} src={props.src} alt={props.alt}></img>
        </div>
    )
}