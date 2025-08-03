import React, {useState} from 'react';
import './App.css';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  const[count, setCount] = useState(0);
  const increment =() => {
    setCount(prev => prev + 1);
    sayHello();
  };
  const decrement = () => {
    setCount(prev => prev - 1);
  };
  const sayHello =() => alert("Hello Member!");

  const sayWelcome = (message) => alert(message);

  const handleClick = (e) =>{
    alert("I was Clicked");
  };

  return (
    <div style={{ padding: '20px' }}>
      <div>{count}</div>
      <button onClick={increment}>Increment</button>
      <button onClick={decrement}>Decrement</button>
      <br /><br />
      <button onClick={() => sayWelcome("welcome")}>Say welcome</button>
      <br /><br />
      <button onClick={handleClick}>Click on me</button>

      <hr />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
