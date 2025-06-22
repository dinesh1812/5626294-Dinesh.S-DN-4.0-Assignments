public class EmployeeManagerTest {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(3);

        // Add Employees
        manager.addEmployee(new Employee(101, "Dinesh", "Developer", 90000));
        manager.addEmployee(new Employee(102, "Bob", "Designer", 65000));
        manager.addEmployee(new Employee(103, "Charlie", "Manager", 75000));

        //Traverse Employees
        System.out.println("List of Employees: ");
        manager.traverseEmployees();

        // Search
        System.out.println("\nSearch Employee with ID 102:");
        Employee emp = manager.searchEmployee(102);
        if (emp != null) emp.display();

        // Delete
        System.out.println("\nDelete Employee with ID 101:");
        manager.deleteEmployee(101);
        manager.traverseEmployees();
    }
}
