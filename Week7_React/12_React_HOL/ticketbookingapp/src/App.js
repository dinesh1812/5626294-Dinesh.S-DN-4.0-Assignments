import React , {useState} from 'react';
import './App.css';
import Greetings from './components/Greetings';
import FlightDetails from './components/FlightDetails';

function App() {
  function LoginButton({onClick}){
    return <button onClick={onClick}>Login</button>;
  }
  function LogoutButton({onClick}){
    return <button onClick={onClick}>Logout</button>;
  }

  const[isLoggedIn, setIsLoggedIn] = useState(false);

  return(
    <div className="App">
      <h1>Ticket Booking App</h1>
      <Greetings isLoggedIn={isLoggedIn} />
      {isLoggedIn ? (
        <LogoutButton onClick={() => setIsLoggedIn(false)} />
      ):(
        <LoginButton onClick={() => setIsLoggedIn(true)} />
      )}
      <FlightDetails />
    </div>
  );
}

export default App;