import './App.css';
import SeccionCategoria from './components/Categoria/SeccionCategoria';
import SeccionHeader from './components/Header/SeccionHeader';
import Listado from './components/Listado/Listado';
import Footer from './components/footer/footer';
import Buscador from './components/Bloque-buscador/Buscador';
import Body from './components/Body/Body';
import Login from './components/login/login';
import Register from './components/Register/register';

function App() {
  return (
    <div className="container">
      <Login />

      {/* <Body>

        <SeccionHeader />
        <Buscador />
        <SeccionCategoria />
        <Listado />
        <Footer />

      </Body> */}
    </div>
  );
}

export default App;