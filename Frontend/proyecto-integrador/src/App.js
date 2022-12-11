import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom"
import Layout from './components/Layout/Layout'
import Home from './components/Home/Home'
import Producto from './components/Tarjeta-Producto/Producto'
import ReservaWrapper from './components/Reserva/ReservaWrapper'
import ReservaExito from './components/ReservaExito/ReservaExito'
import Login from './components/Login/Login';
import Register from './components/Register/Register';
import CrearProducto from './components/CrearProducto/CrearProducto';
import ProductoExito from './components/ProductoExito/ProductoExito';


function App() {

  return (
    <div className="container">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Layout/>}>
            <Route path='/' element={<Home/>}/>
            <Route path='/iniciar_sesion' element={<Login/>}/>
            <Route path='/registrarse' element={<Register/>} />
            <Route path='/administracion/crearproducto' element={<CrearProducto />} />
            <Route path='/administracion/crearproducto/exito' element={<ProductoExito />} />
            <Route path='/producto/:id' element={<Producto />} />
            <Route path='/reserva/producto/:id' element={<ReservaWrapper />} />
            <Route path='reserva/exito' element={<ReservaExito />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;