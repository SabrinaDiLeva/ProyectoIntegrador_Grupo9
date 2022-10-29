import './App.css';
import SeccionCategoria from './components/Categoria/SeccionCategoria';
import Header from './components/Header/Header';
import SeccionHeader from './components/Header/SeccionHeader';
import Login from './components/login/login';
import Register from './components/Register/register';


function App() {
  return (
    <div className="App">
      {/* <Login/>
      <Register/> */}
      <Header/>
    </div>
  );
}

export default App;