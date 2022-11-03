import './App.css';
import SeccionCategoria from './components/Categoria/SeccionCategoria';
import Header from './components/Header/Header';
import SeccionHeader from './components/Header/SeccionHeader';
import Listado from './components/Listado/Listado';
import Footer from './components/Footer/Footer';
import Buscador from './components/Bloque-buscador/Buscador';
import Body from './components/Body/Body';
import Login from './components/Login/Login';
import Register from './components/Register/Register';

function App() {
  return (
<<<<<<< HEAD
    <div className="App">
      {/* <Login/>
      <Register/> */}
      <Header/>
    </div>
=======
    <div className="container">
      <Body>
        <SeccionHeader />
        <Buscador />
        <SeccionCategoria />
        <Listado/>
        <Footer />
      </Body>
   </div>
>>>>>>> 5f4d18a274173e9d662015852921d364d12d9366
  );
}

export default App;