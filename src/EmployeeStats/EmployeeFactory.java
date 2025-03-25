/**
 * Created by Ritabrata
 */

package EmployeeStats;

// Factory class to create Employee objects dynamically
public class EmployeeFactory {
    public static Employee createEmployee(String type, String name, int id, String department, double param1, double param2) {
        switch (type.toLowerCase()) {
            case "fulltime":
                return new FullTimeEmployee(name, id, department, param1, param2);
            case "parttime":
                return new PartTimeEmployee(name, id, department, (int) param1, param2);
            case "contract":
                return new ContractEmployee(name, id, department, param1);
            default:
                throw new IllegalArgumentException("Invalid Employee Type");
        }
    }
}
