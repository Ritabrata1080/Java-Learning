/**
 * Created by Ritabrata
 */


package lld_strategy_design_pattern.strategy;

public class Vehicle {
    DriveStrategy driveStrategy;

    // constructor injection
    Vehicle(DriveStrategy driveStrategyObj) {
        driveStrategy = driveStrategyObj;
    }

    public void drive() {
        driveStrategy.drive();
    }
}
