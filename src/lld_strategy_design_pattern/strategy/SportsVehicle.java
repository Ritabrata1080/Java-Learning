/**
 * Created by Ritabrata
 */


package lld_strategy_design_pattern.strategy;

public class SportsVehicle extends Vehicle {
    SportsVehicle() {
        super(new SpecialDriveStrategy());
    }
}
