import style from "./burger.module.css"
import { MdClose } from "react-icons/md"
import { FiMenu } from "react-icons/fi"

export default function burgerIcon(props) {
    return (
        <button className={style.hamburguesaButton} onClick={props.handleToggle}>
            {props.open ? (
                <MdClose className={style.icon} />) : (
                <FiMenu className={style.icon} />)
            }
        </button>
    )
}