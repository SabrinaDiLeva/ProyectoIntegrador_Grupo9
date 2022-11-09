import style from './Body.module.css'

export default function Body({children}){
    return (
        <>
        <div className={style.body}>
            {children}
        </div>
        </>
    )
}