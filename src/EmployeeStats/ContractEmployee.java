/**
 * Created by Ritabrata
 */

package EmployeeStats;

// Concrete class representing a Contract Employee
public class ContractEmployee extends Employee {
    private double contractAmount;

    public ContractEmployee(String name, int id, String department, double contractAmount) {
        super(name, id, department);
        this.contractAmount = contractAmount;
    }

    @Override
    public void calculateSalary() {
        this.salary = contractAmount;
    }
}