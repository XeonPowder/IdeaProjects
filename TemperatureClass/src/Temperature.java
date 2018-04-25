/**
 * The Temperature class allows for the conversion between different temperature scales.
 */
public class Temperature {
    //attributes
    private double ftemp;

    /**
     * Constructs a new Temperature object, capable of converting to different temperature scales.
     * @param fahrenheit 8 byte real number defining temperature in the fahrenheit scale.
     */
    public Temperature(double fahrenheit) { setFahrenheit(fahrenheit); }

    //modifiers
    public void setFahrenheit(double temp) { this.ftemp = temp; }

    //accessors
    public double getFahrenheit() { return this.ftemp; }
    public double getCelsius() { return ((5*(getFahrenheit()-32)/9)); }
    public double getKelvin() { return getCelsius() + 273; }

}
