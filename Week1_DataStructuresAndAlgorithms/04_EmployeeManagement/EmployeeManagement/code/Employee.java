public class Employee {
    private int employeeId;
    private String employeeName;
    private String position;
    private double salary;

    public Employee(int employeeId, String employeeName, String position, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getemployeeName() {
        return employeeName;
    }

    public void setemployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void display() {
        System.out.println("ID: " + employeeId + ", Name: " + employeeName +
                ", Position: " + position + ", Salary: " + salary);
    }
}
