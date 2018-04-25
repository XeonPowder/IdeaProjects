/**
 * Description: This program will construct a Car object and call upon it's functions
 * Class: Fall - COSC 1437.83003
 * Assignment4: Car Class
 * Date: 02/08/2018
 * @author  Lars Van der Zande
 * @version 1.0.0
 */
public class CarDemo {
    /**
     * Uses the Car class' accelerate and brake methods to manipulate inaccessible attributes of the car. Displays the speed of the car after acceleration and deceleration.
     * @param args not used.
     */
    public static void main(String[] args) {
        Car chevy = new Car("Chevrolet", 1999);
        for (int x = 0; x < 10; x++) {
            System.out.print(chevy.getYearModel() +" "+chevy.getMake()+" ");
            if (x < 5) {
                chevy.accelerate();
                System.out.print("accelerates to ");
            } else {
                chevy.brake();
                System.out.print("brakes to ");
            }
            System.out.println((chevy.getSpeed() > 0) ? (chevy.getSpeed() +" mph.") : "a stop." );
        }
    }
}
