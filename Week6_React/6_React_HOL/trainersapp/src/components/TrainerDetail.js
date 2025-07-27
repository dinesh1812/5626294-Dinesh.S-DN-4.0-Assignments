import { useParams } from "react-router-dom";
import trainers from "./TrainerMock";

function TrainerDetail() {
  const { id } = useParams();
  const trainer = trainers.find((t) => t.id === Number(id));

  if (!trainer) return <p>Trainer not found.</p>;

  return (
    <div>
      <h3>Trainers Details</h3>
      <p>
        <strong>{trainer.name}</strong> ({trainer.technology})
      </p>
      <p>{trainer.email}</p>
      <p>{trainer.contact}</p>
      <ul>
        {trainer.skills.map((skill, index) => (
          <li key={index}>{skill}</li>
        ))}
      </ul>
    </div>
  );
}
export default TrainerDetail;
