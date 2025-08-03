import './App.css';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';
import { books } from './data/books';
import { blogs } from './data/blogs';
import { courses } from './data/courses';

function App() {
  const showBooks = true;
  const showBlogs = true;
  const showCourses = true;

  return (
    <div>
      <div className="container">

        <div className="box mystyle1">
          <h1>Course Details</h1>
          {showCourses ? (
            <CourseDetails courses={courses} />
          ) : (
            <p>No courses available</p>
          )}
        </div>
        
        <div className="box st2">
          <h1>Book Details</h1>
          {showBooks && <BookDetails books={books} />}
        </div>

        <div className="box v1">
          <h1>Blog Details</h1>
          {showBlogs ? <BlogDetails blogs={blogs} /> : <p>No blogs to show</p>}
        </div>

        
      </div>
    </div>
  );
}

export default App;
