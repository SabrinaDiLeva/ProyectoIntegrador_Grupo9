import style from "./boton.module.css"
import {Link} from "react-router-dom"

export default function Boton(props){
   return <button className={style.button}> <Link className={style.link} to={props.to}>Ver detalle</Link></button>
}