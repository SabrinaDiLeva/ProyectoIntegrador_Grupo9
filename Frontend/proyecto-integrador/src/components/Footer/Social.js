import style from "./social.module.css"
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { brands } from '@fortawesome/fontawesome-svg-core/import.macro';

export default function Social() {
    return (
        <span className={style.footerIcons}>
            <a className={style.icono} href='/'><FontAwesomeIcon icon={brands('twitter')} /></a>
            <a className={style.icono} href='/'><FontAwesomeIcon icon={brands('facebook')} /></a>
            <a className={style.icono} href='/'><FontAwesomeIcon icon={brands('instagram')} /></a>
            <a className={style.icono} href='/'><FontAwesomeIcon icon={brands('linkedin')} /></a>
        </span>
    )
}