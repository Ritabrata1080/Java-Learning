/**
 * Created by Ritabrata
 */

package EmployeeStats;

// Main class to test the implementation
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        // Creating employees using the Factory Pattern
        Employee emp1 = EmployeeFactory.createEmployee("fulltime", "Alice", 101, "HR", 5000, 500);
        Employee emp2 = EmployeeFactory.createEmployee("parttime", "Bob", 102, "IT", 40, 20);
        Employee emp3 = EmployeeFactory.createEmployee("contract", "Charlie", 103, "Finance", 3000, 0);

        // Adding employees to the manager
        manager.addEmployee(emp1);
        manager.addEmployee(emp2);
        manager.addEmployee(emp3);

        // Displaying all employees
        manager.displayAllEmployees();

        // Generating a salary report
        manager.generateReport();
    }
}
