import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom"
<<<<<<< HEAD
import SeccionCategoria from './components/Categoria/SeccionCategoria';
import Listado from './components/Listado/Listado';
import Buscador from './components/Bloque-buscador/Buscador';
import Layout from './components/Layout/Layout'
import Producto from './components/Tarjeta-Producto/Producto'
import ReservaWrapper from './components/Reserva/ReservaWrapper'
import ReservaExito from './components/ReservaExito/ReservaExito'
import Login from './components/Login/Login';
import Register from './components/Register/Register';
=======
import SeccionCategoria from './components/Categoria/SeccionCategoria.js';
import Listado from './components/Listado/Listado.js';
import Buscador from './components/Bloque-buscador/Buscador.js';
import Layout from './components/Layout/Layout.js'
import Producto from './components/Tarjeta-Producto/Producto.js'
import Register from './components/Register/Register';
import Login from './components/Login/Login';
>>>>>>> daa76d218e2402f4e2ed7e8a758ce90f18001634

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
<<<<<<< HEAD
            <Route path='/reserva/producto/:id' element={
              <ReservaWrapper />
            }/> 
            <Route path='/exito' element={
              <ReservaExito/>
            }/> 
          </Route>
        </Routes>
      </BrowserRouter>
   </div>
=======
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
>>>>>>> daa76d218e2402f4e2ed7e8a758ce90f18001634
  );
}

export default App;