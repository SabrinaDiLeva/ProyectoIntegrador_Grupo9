import Header from './Header'
import data from './headerInfo.json'

export default function SeccionHeader() {
    const headers = data

    return (
        <>
        <Header key={headers.key} imagen={headers.images} slogan={headers.slogan} logoUsuario={headers.logoUsuario}/>
        </>
    )
    
}