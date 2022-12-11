import style from "./slogan.module.css"
import slogan from '../headerInfo.json'

export default function Slogan() {
    const randomSloganIndex = Math.round(Math.random() * (slogan.length -1) );

    return (
        <span className={style.slogan}> {slogan[randomSloganIndex].slogan} </span>
    )
}