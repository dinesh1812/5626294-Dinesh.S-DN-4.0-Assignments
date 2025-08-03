import React from 'react'

function ScoreBelow70({players}) {
    const playersBelow70 = players.filter((item) => item.score <= 70);
  return (
    <div>
        {playersBelow70.map((item, index) =>(
            <li key = {index}>
                Mr. {item.name} <span>{item.score}</span>
            </li>
        ))}
    </div>
  );
}

export default ScoreBelow70;