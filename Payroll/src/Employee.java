public class Employee {
    private final int PAYRATE_MIN = 6;

    private int identifier;
    private int hours;
    private double payRate;

    public Employee() {
        this.identifier = Integer.parseInt(Double.toString(Math.random() * 1000000), 10);
        this.hours = 0;
        this.payRate = PAYRATE_MIN;
    }

    public Employee(int identifier, int hours, double payRate, double wage) {
        this.identifier = (identifier >= 0) ? identifier : Integer.parseInt(Double.toString(Math.random() * 1000000), 10);
        this.hours = (hours >= 0) ? hours : 0;
        this.payRate = (payRate >= PAYRATE_MIN) ? payRate : PAYRATE_MIN;
    }

    public void setHours(int hours) { this.hours = hours; }
    public void setPayRate(double payRate) { this.payRate = (payRate >= PAYRATE_MIN) ? payRate : PAYRATE_MIN; }

    public int getIdentifier() { return this.identifier; }
    public double getWage() { return (int)(this.payRate*this.hours); }

}
