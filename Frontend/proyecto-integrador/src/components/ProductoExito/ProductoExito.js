import style from "./ProductoExito.module.css";
import ExitoContainer from "../ReservaExito/subcomponents/ExitoContainer";

export default function ProductoExito() {
    return (
        <div className={style.container}>
            <ExitoContainer confirm={'Tu propiedad se ha creado con éxito.'} ok={'Volver'} />
        </div>
    )
}