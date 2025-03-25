/**
 * Created by Ritabrata
 */


package EmployeeStats;

// Abstract class representing a generic employee
abstract class Employee implements EmployeeOperations {
    public String name;
    public int id;
    public String department;
    public double salary;
    public Employee(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    // Abstract method (will be implemented in child classes)
    public abstract void calculateSalary();

    // Display common employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}
