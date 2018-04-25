/**
 * Description: This program will construct a Circle object and call upon it's functions
 * Class: Fall - COSC 1437.83003
 * Assignment4: Circle Class
 * Date: 02/08/2018
 * @author  Lars Van der Zande
 * @version 1.0.0
 */
public class CircleDemo {
    /**
     * Demonstrates the creation and use of a Circle object.
     * @param args not used.
     */
    public static void main(String[] args) {
        System.out.print("What is the radius of the circle: ");
        java.util.Scanner input = new java.util.Scanner(System.in);
        double radius = input.nextDouble();
        input.nextLine();
        while(radius <= 0) {
            System.out.print("What is the radius of the circle: ");
            radius = input.nextDouble();
            input.nextLine();
        }
        Circle circle = new Circle(radius);
        System.out.printf("Area: %.2f sq. units\nDiameter: %.2f units\nCircumference: %.2f units", circle.getArea(), circle.getDiameter(), circle.getCircumference());
    }
}
