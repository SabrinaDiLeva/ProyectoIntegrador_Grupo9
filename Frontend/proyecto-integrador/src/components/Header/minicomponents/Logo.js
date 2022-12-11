import style from "./logo.module.css"
import Logo from '../../ui/logo.png'

export default function LogoSlogan(props) {

  return (
    <div className={style.container}>
      <img className={style.logo} src={Logo} alt={props.nombre} />
    </div>
  )
}