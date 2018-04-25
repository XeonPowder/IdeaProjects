/**
 * The FuelAndMileageDemo demonstrates the aggregation of two classes (FuelGauge and Odometer).
 * Class: Spring - COSC 1437.80083
 * Assignment7: Car Instrument Simulator
 * Date: 3/22/2018
 * @author Lars Van der Zande
 * @version 0.0.1
 */
public class FuelAndMileageDemo {
    /**
     * Simulates filling a car with gas to the maximum fuel capacity. Drives the car until there is no gas left.
     * @param args unused
     */
    public static void main(String[] args) {

        // construct a new FuelGauge object
        FuelGauge fuelGauge = new FuelGauge();

        // fill up the gas tank
        while(fuelGauge.getGallons() < fuelGauge.MAX_GALLONS) {
            fuelGauge.incrementGallons();
        }
        // construct a new Odometer object
        Odometer odometer = new Odometer(0, fuelGauge);

        // drive the car until the car is out of gas
        while(fuelGauge.getGallons() > 0) {
            odometer.incrementMileage();
            System.out.printf("Mileage: %d, Fuel: %d\n", odometer.getMileage(), fuelGauge.getGallons());
        }
    }
}
