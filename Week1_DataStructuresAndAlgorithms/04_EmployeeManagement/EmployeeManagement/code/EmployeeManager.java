
public class EmployeeManager {
    private Employee[] employees;
    private int employeeCount;

    public EmployeeManager(int capacity){
        employees = new Employee[capacity];
        employeeCount = 0;
    }

    // Add a new Employee
    public void addEmployee(Employee e){
        if(employeeCount >= employees.length){
            resize();       // Resize the array if there are more employees than the size of array.
        }
        employees[employeeCount++] = e;
    }

    // Resize the Array
    private void resize(){
        Employee[] newArray = new Employee[employees.length * 2];
        for(int i = 0; i < employees.length; i++){
            newArray[i] = employees[i];
        }
        employees = newArray;
    }

    // Search Employee
    public Employee searchEmployee(int id){
        for(int i = 0; i < employeeCount; i++){
            if(employees[i].getEmployeeId() == id){
                return employees[i];
            }
        }
        System.out.println("Employee Not Found.");
        return null;
    }

    // Delete Employee from Array
    public void deleteEmployee(int id){
        for(int i = 0; i < employees.length; i++){
            if(employees[i].getEmployeeId() == id){
                for(int j = i; j < employeeCount - 1; j++){
                    employees[j] = employees[j + 1];
                }
                employees[--employeeCount] = null;
                return;
            }
        }
        System.out.println("Employee Not Found.");
    }

    public void traverseEmployees(){
        for(int i = 0; i < employeeCount; i++){
            employees[i].display();
        }
    }
}
