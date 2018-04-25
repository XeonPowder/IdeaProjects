/**
 * Description: This program will construct a Temperature object and call upon it's functions
 * Class: Fall - COSC 1437.83003
 * Assignment4: Temperature Class
 * Date: 02/08/2018
 * @author  Lars Van der Zande
 * @version 1.0.0
 */
public class TemperatureDemo {
    /**
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        System.out.print("What is the current temperature: ");
        Temperature temperature = new Temperature(new java.util.Scanner(System.in).nextDouble());
        System.out.printf("Current temperature: %.2f °F, %.2f °C, %.2f °K\n", temperature.getFahrenheit(), temperature.getCelsius(), temperature.getKelvin());
    }

}
