import './App.css';
import SeccionCategoria from './components/Categoria/SeccionCategoria';
import SeccionHeader from './components/Header/SeccionHeader';
import Body from './components/Body/Body';

function App() {
  return (
    <div className="container">
      {/* <Body/> */}
        <SeccionHeader />
        <SeccionCategoria />
      {/* </Body> */}
   </div>
  );
}

export default App;