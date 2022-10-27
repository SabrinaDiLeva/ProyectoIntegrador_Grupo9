import './App.css';
import SeccionCategoria from './components/Categoria/SeccionCategoria';
import SeccionHeader from './components/Header/SeccionHeader';
import Listado from './components/Listado/Listado';
import Footer from './components/Footer/Footer';
import Buscador from './components/Bloque-buscador/Buscador';
import Body from './components/Body/Body';
import Login from './components/Login/Login';
import Register from './components/Register/Register';

function App() {
  return (
    <div className="container">
      <Body>
        <SeccionHeader />
        <Buscador />
        <SeccionCategoria />
        <Listado/>
        <Footer />
      </Body>
   </div>
  );
}

export default App;