import './App.css';
import SeccionCategoria from './components/Categoria/SeccionCategoria';
import SeccionHeader from './components/Header/SeccionHeader';


function App() {
  return (
    <div className="App">
      <SeccionHeader />
      <SeccionCategoria />
    </div>
  );
}

export default App;