/**
 * The Circle class allows for the computation of Area, Diameter, and Circumference given a radius.
 */
public class Circle {
    //attributes
    private double radius;
    private final double PI = 3.14159;

    /**
     * Creates a new Circle object and assigns the radius from parameter.
     * @param radius defines the circle's radius.
     */
    public Circle(double radius) { setRadius(radius); }

    // modifiers
    public void setRadius(double radius) { this.radius = radius; }

    // accessors
    public double getRadius() { return this.radius; }
    public double getArea(){ return this.PI * this.getRadius() * this.getRadius(); }
    public double getDiameter() { return this.getRadius()*2; }
    public double getCircumference() { return 2 * this.PI * this.getRadius(); }
}
