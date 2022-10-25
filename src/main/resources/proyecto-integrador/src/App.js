import './App.css';
import SeccionCategoria from './components/Categoria/SeccionCategoria';
import SeccionHeader from './components/Header/SeccionHeader';
import Listado from './components/Listado/Listado.js';
import Body from './components/Body/Body';

function App() {
  return (
    <div className="container">
      {/* <Body/> */}
        <SeccionHeader />
        <SeccionCategoria />
        <Listado/>
      {/* </Body> */}
   </div>
  );
}

export default App;