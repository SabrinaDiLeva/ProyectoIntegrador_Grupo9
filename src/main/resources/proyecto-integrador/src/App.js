import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom"
import SeccionCategoria from './components/Categoria/SeccionCategoria';
<<<<<<< HEAD
=======
import Header from './components/Header/Header';
import SeccionHeader from './components/Header/SeccionHeader';
>>>>>>> 5848545f0901d1e8e9b410a0924121e7298f33a0
import Listado from './components/Listado/Listado';
import Buscador from './components/Bloque-buscador/Buscador';
import Login from './components/Login/Login';
import Register from './components/Register/Register';
import Layout from './components/Layout/Layout'
import Producto from './components/Tarjeta-Producto/Producto'

function App() {
  window.onscroll = () => {
    
  }



  return (
<<<<<<< HEAD
    <div className="App">
      {/* <Login/>
      <Register/> */}
      <Header/>
    </div>
=======
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
            <Route path='/producto' element={<>
              <Producto/>
            </>}/> 
          </Route>
        </Routes>
      </BrowserRouter>
   </div>
>>>>>>> 5f4d18a274173e9d662015852921d364d12d9366
  );
}

export default App;