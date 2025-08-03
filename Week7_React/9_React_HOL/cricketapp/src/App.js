import "./App.css";
import ListOfPlayers from "./components/ListOfPlayers";
import ScoreBelow70 from "./components/ScoreBelow70";
import { OddPlayers } from "./components/OddPlayers";
import { EvenPlayers } from "./components/EvenPlayers";
import ListofIndianPlayers from "./components/ListOfIndianPlayers";
function App() {
  const flag = true;
  const players = [
    { name: "Sachin", score: 65 },
    { name: "Dhoni", score: 60 },
    { name: "Virat", score: 64 },
    { name: "Rohit", score: 60 }
  ];
  const T20Players = ["First Player", "Second Player", "Third Player"];
  const RanjiTrophyPlayers = ["Fourth Player", "Fifth Player", "Sixth Player"];
  const IndianPlayers = [...T20Players, ...RanjiTrophyPlayers];

  const IndianTeam = [
    "Sachin1",
    "Dhoni2",
    "Virat3",
    "Rohit4",
    "Yuvaraj5",
    "Raina6"
  ];

  if (flag == true) {
    return (
      <div>
        <h1>List of Players</h1>
        <ListOfPlayers players={players} />
        <hr />
        <h1>List of Players having Score Less than 70</h1>
        <ScoreBelow70 players={players} />
      </div>
    );
  } else {
    return (
      <div>
        <div>
          <h1>Indian Team</h1>
          <h1>Odd Players</h1>
          {OddPlayers(IndianTeam)}

          <h1>Even Players</h1>
          {EvenPlayers(IndianTeam)}
        </div>

        <hr />
        <div>
          <h1>List of Indian Players Merged:</h1>
          <ListofIndianPlayers IndianPlayers={IndianPlayers} />
        </div>
      </div>
    );
  }
}

export default App;
