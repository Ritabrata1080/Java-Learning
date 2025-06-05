/**
 * Created by Ritabrata
 */


package lld_strategy_design_pattern.strategy;

public class GoodsVehicle extends Vehicle {
    GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
