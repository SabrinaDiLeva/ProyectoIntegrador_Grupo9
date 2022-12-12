import style from "./perfil.module.css"

export default function Perfil(props) {
    return (
        <div className={style.perfil}>
            <span className={style.avatar}>
                {props.user ? `${props.user.nameLetter}${props.user.lastNameLetter}` : 'N/A'}
            </span>
            <span className={style.perfilUsuario}>
                <a className={style.linkPerfil} href="/">
                    <p className={style.saludo}>Hola,</p>
                    <p className={style.saludo2}>{props.user ? `${props.user.name} ${props.user.lastname}` : ''}</p>
                </a>
            </span>
        </div>

    )
}