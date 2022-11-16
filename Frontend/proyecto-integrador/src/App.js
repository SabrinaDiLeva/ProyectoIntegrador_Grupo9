import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom"
import SeccionCategoria from './components/Categoria/SeccionCategoria.js';
import Listado from './components/Listado/Listado.js';
import Buscador from './components/Bloque-buscador/Buscador.js';
import Register from './components/Register/Register.js';
import Layout from './components/Layout/Layout.js'
import Producto from './components/Tarjeta-Producto/Producto.js'
import Login from './components/Login/login';

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
          </Route>
        </Routes>
      </BrowserRouter>
   </div>
  );
}

export default App;