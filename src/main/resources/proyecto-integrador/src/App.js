
import './App.css';
import Footer from './footer/footer.js';
import Buscador from './Bloque-buscador/Buscador';

function App() {
  return (
    <div className='page-container'>
      <div className='container-wrap'>
        <Buscador />
        <Footer />
      </div>
    </div>

  );
}

export default App;
