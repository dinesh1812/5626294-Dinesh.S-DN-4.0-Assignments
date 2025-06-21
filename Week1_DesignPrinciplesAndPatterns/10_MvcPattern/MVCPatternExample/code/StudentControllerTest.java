public class StudentControllerTest {
    public static void main(String[] args) {
        
        Student student1 = new Student(1, "Dinesh", "A");

        StudentView view = new StudentView();

        StudentController controller1 = new StudentController(student1, view);

        //Student details prined using View
        controller1.update();
        System.out.println();

        //Updating and Displaying Student details
        controller1.setStudentGrade("A+");
        controller1.update();
        System.out.println();


        Student student2 = new Student(2, "John", "O");
        StudentController controller2 = new StudentController(student2, view);
        controller2.update();
    }
}
