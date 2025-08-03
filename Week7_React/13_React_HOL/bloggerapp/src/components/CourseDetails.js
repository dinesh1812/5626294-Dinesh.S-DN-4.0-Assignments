function CourseDetails({ courses }) {
  return (
    <ul>
      {courses.map((course, index) => (
        <div key={index}>
          <h2>{course.name}</h2>
          <h4>{course.date}</h4>
        </div>
      ))}
    </ul>
  );
}

export default CourseDetails;