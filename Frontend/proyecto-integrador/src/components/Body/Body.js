import style from './Body.module.css'

export default function Body({children}){
    return (
        <>
        <div id="body" className={style.body}>
            {children}
        </div>
        </>
    )
}