export default function Card() {
    return <>
    <div>
        <div className="imageContainer">
            <img className="image" src="" alt="producto"></img>
        </div>
        <div className="infoContainer">
            <p className="info-categoria">Categoria</p>
            <p className="info-producto">Producto</p>
            <p className="info-nombre">Nombre</p>
            <p className="info-descripcion">Descripcion</p>
            <button className="info-boton">Ver detalle</button>
        </div>
    </div>
    </>
}