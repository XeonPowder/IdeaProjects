/**
 * The Odometer class is used inside of a car to measure the amount of miles traveled, in conjunction with the FuelGauge class the odometer keeps track of the amount of fuel left in the tank.
 * Class: Spring - COSC 1437.80083
 * Assignment7: Car Instrument Simulator
 * Date: 3/22/2018
 * @author Lars Van der Zande
 * @version 0.0.1
 */
public class Odometer {
    public final int MAX_MILEAGE = 999999;
    public final int MPG = 24;
    private int mileage;
    private int setPoint;
    private FuelGauge fuelGauge;

    /**
     * 2 argument Constructor for this Odometer class.
     * @param mileage Integer, non-negative number. If a negative number is passed to this parameter, the mileage is set to 0.
     * @param fuelGauge Instance Object, FuelGauge Class.
     */
    public Odometer(int mileage, FuelGauge fuelGauge) {
        this.mileage = (mileage >= 0) ? mileage : 0;
        this.fuelGauge = fuelGauge;
    }

    /**
     * The current mileage counted by the Odometer, the mileage can only be incremented via the incrementMileage function
     * @return Integer, non-negative real number.
     */
    public int getMileage() { return this.mileage; }

    /**
     * Increases the mileage counted by the odometer by 1. If the MAX_MILEAGE is reached by the odometer, mileage is reset to 0. Every time the mileage reaches a multiple of the car's MPG, the amount of gallons of gas in the fuel tank, counted by a FuelGauge object, is decreased by 1.
     */
    public void incrementMileage() {
        if (this.fuelGauge.getGallons() > 0) {
            if (this.mileage == MAX_MILEAGE) this.mileage = 0;
            this.mileage++;
            this.setPoint++;
            if (this.setPoint == MPG) {
                this.setPoint = 0;
                this.fuelGauge.decrementGallons();
            }
        }

    }
}
