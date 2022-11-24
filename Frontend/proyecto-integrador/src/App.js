import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom"
import SeccionCategoria from './components/Categoria/SeccionCategoria';
import Listado from './components/Listado/Listado';
import Buscador from './components/Bloque-buscador/Buscador';
import Layout from './components/Layout/Layout'
import Producto from './components/Tarjeta-Producto/Producto'
import Reserva from './components/Reserva/Reserva'
import ReservaExito from './components/ReservaExito/ReservaExito'
import Login from './components/Login/Login';
import Register from './components/Register/Register';

function App() {

  return (
    <div className="container">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Layout/>}>
            <Route path='/' element={<>
              <Buscador/> 
              <SeccionCategoria/>
              <Listado/>
            </>}/> 
            <Route path='/iniciar_sesion' element={<>
              <Login/>
            </>}/> 
            <Route path='/registrarse' element={<>
              <Register/>
            </>}/> 
            <Route path='/producto/:id' element={
              <Producto/>
            }/> 
            <Route path='/reserva/producto/:id' element={
              <Reserva/>
            }/> 
            <Route path='/exito' element={
              <ReservaExito/>
            }/> 
          </Route>
        </Routes>
      </BrowserRouter>
   </div>
  );
}

export default App;