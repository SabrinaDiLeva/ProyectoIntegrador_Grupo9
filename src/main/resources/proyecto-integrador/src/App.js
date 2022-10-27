import './App.css';import { BrowserRouter, Routes, Route } from "react-router-dom"
import SeccionCategoria from './components/Categoria/SeccionCategoria';
import SeccionHeader from './components/Header/SeccionHeader';
import Listado from './components/Listado/Listado';
import Footer from './components/Footer/Footer';
import Body from './components/Body/Body';
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