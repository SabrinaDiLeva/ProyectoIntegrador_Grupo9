import './App.css';
import SeccionCategoria from './components/Categoria/SeccionCategoria';
import SeccionHeader from './components/Header/SeccionHeader';

function App() {
  return (
    <div className="container">
      <SeccionHeader />
      <SeccionCategoria />
   </div>
  );
}

export default App;