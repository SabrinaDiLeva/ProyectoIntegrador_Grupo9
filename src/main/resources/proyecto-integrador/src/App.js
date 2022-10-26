import './App.css';
import SeccionCategoria from './components/Categoria/SeccionCategoria';
import SeccionHeader from './components/Header/SeccionHeader';
import Listado from './components/Listado/Listado.js';
import Footer from './components/footer/footer.js';
import Buscador from './components/Bloque-buscador/Buscador';
import Body from './components/Body/Body';

function App() {
  return (
    <div className="container">
      {/* <Body/> */}
        <SeccionHeader />
        <Buscador />
        <SeccionCategoria />
        <Listado/>
        <Footer />
      {/* </Body> */}
   </div>
  );
}

export default App;