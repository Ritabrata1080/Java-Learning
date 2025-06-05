/**
 * Created by Ritabrata
 */


package EmployeeStats;

// Concrete class representing a Full-Time Employee
public class FullTimeEmployee extends Employee {
    private double basicPay;
    private double bonus;

    public FullTimeEmployee(String name, int id, String department, double basicPay, double bonus) {
        super(name, id, department);
        this.basicPay = basicPay;
        this.bonus = bonus;
    }

    @Override
    public void calculateSalary() {
        this.salary = basicPay + bonus;
    }
}
