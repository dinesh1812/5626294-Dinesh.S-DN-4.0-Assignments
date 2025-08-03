import './App.css';

function App() {
  const heading = "Office Space";
  const offices = [
    { Name: "DBS", Rent: 50000, Address: "Chennai", img: "https://img.freepik.com/free-photo/empty-room-with-chairs-desks_23-2149008873.jpg" },
    { Name: "Regus", Rent: 70000, Address: "Bangalore", img: "https://img.freepik.com/free-photo/empty-room-with-chairs-desks_23-2149008873.jpg" },
    { Name: "WeWork", Rent: 55000, Address: "Mumbai", img: "https://img.freepik.com/free-photo/empty-room-with-chairs-desks_23-2149008873.jpg" }
  ];
  return(
    <div className="App">
      <h1>{heading}, at Affordable Range</h1>
      {offices.map((item, index) =>{
        const rentColor = item.Rent <= 60000 ? 'textRed' : 'textGreen';
        return(
          <div key={index}>
            <img src={item.img} width = "25%" height = "25%" alt ="Office space" />
            <h2>Name: {item.Name}</h2>
            <h3 className = {rentColor}>Rent: Rs. {item.Rent}</h3>
            <h3>Address: {item.Address}</h3>
            <br />
          </div>
        );
      })}
    </div>
  );
}

export default App;
