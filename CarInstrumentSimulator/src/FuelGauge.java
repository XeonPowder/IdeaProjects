/**
 * The FuelGauge class is used by the Odometer class to measure the amount of fuel left in the fuel tank
 * Class: Spring - COSC 1437.80083
 * Assignment7: Car Instrument Simulator
 * Date: 3/22/2018
 * @author Lars Van der Zande
 * @version 0.0.1
 */
public class FuelGauge {
    public final int MAX_GALLONS = 15;
    private int gallons;

    /**
     * Constructs a FuelGauge Object. no-arg Constructor, sets the amount of gas in the tank to 0 gallons.
     */
    public FuelGauge() {
        this.gallons = 0;
    }

    /**
     * Constructs a FuelGauge Object. takes one argument, the amount of gallons of gas in the tank.
     * @param gallons Integer, non-negative number
     */
    public FuelGauge(int gallons) { this.gallons = (this.gallons >= 0) ?  gallons : 0; }

    /**
     * Deep Copy Constructor. Copies another FuelGauge instance into this FuelGauge object instance. If the object to be copied is null, default the amount of gallons of gas to 0.
     * @param fuelGauge the object to be deep copied
     */
    public FuelGauge(FuelGauge fuelGauge) { this.gallons = (fuelGauge != null && fuelGauge.gallons >= 0) ? fuelGauge.gallons : 0; }

    /**
     * Get the amount of gallons in the fuel tank
     * @return Integer, non-negative number
     */
    public int getGallons() { return this.gallons; }

    /**
     * Add 1 gallon of fuel to the fuel tank, to a maximum of the constant MAX_GALLONS, which is 15 gallons.
     */
    public void incrementGallons() {
        if (this.gallons < MAX_GALLONS) this.gallons++;
    }

    /**
     * Remove 1 gallon from the fuel tank, cannot go less than 0
     */
    public void decrementGallons() {
        if (this.gallons > 0) this.gallons--;
    }
}
