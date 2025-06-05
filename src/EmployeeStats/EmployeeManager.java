/**
 * Created by Ritabrata
 */

package EmployeeStats;

import java.util.ArrayList;
import java.util.List;

// Class for managing employees and generating reports
public class EmployeeManager implements ReportGenerator {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee emp) {
        emp.calculateSalary();
        employees.add(emp);
    }

    public void displayAllEmployees() {
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("---------------------------");
        }
    }

    public void generateReport() {
        System.out.println("===== Employee Salary Report =====");
        for (Employee emp : employees) {
            System.out.println(emp.name + " | Salary: $" + emp.salary);
        }
        System.out.println("=================================");
    }
}
