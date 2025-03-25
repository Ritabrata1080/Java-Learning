/**
 * Created by Ritabrata
 */


package EmployeeStats;

// Concrete class representing a Part-Time Employee
public class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, String department, int hoursWorked, double hourlyRate) {
        super(name, id, department);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public void calculateSalary() {
        this.salary = hoursWorked * hourlyRate;
    }
}
