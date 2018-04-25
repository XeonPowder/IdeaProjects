/**
 * This class defines a Car data type that is able to accelerate and brake.
 */
public class Car {

    //attributes
    private int yearModel;
    private String make;
    private double speed;

    /**
     * Constructs a new Car object and initializes its attributes.
     * @param make the brand of the car.
     * @param yearModel the year the car's model was created.
     */
    public Car(String make, int yearModel) {
        this.make = (make != null) ? make : "Unknown";
        this.yearModel = yearModel;
        this.speed = 0;
    }

    // accessors
    public int getYearModel() { return this.yearModel; }
    public String getMake() { return this.make; }
    public double getSpeed() { return this.speed; }

    // modifiers
    public void accelerate() { this.speed+=5; }
    public void brake() {  this.speed = (getSpeed() >= 5) ? this.speed-5 : 0; }

 }
