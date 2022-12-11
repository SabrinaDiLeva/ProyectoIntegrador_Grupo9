import SeccionCategoria from '../Categoria/SeccionCategoria';
import Listado from '../Listado/Listado';
import Buscador from '../Bloque-buscador/Buscador';

export default function Home() {
    return  ( 
    <>
        <Buscador />
        <SeccionCategoria />
        <Listado />
    </>)
}