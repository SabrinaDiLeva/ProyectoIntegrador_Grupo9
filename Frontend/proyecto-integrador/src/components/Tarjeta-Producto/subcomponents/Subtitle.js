import style from "./subtitle.module.css"

export default function Subtitle(props) {
    return (
        <span className={style.subtitle}>
            <h2>{props.subtitle}</h2>
        </span>
    )
}