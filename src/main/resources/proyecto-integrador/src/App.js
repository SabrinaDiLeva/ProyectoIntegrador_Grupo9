import './App.css';import { BrowserRouter, Routes, Route } from "react-router-dom"
import SeccionCategoria from './components/Categoria/SeccionCategoria';
import Listado from './components/Listado/Listado';
import Footer from './components/Footer/Footer';
import Buscador from './components/Bloque-buscador/Buscador';
import Login from './components/Login/Login';
import Register from './components/Register/Register';
import Layout from './components/Layout/Layout'

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
      </Route>
      </Routes>
        <Footer />
      </BrowserRouter>
   </div>
  );
}

export default App;