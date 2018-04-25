/**
 * Description: This class is the computer implementation of a die https://en.wikipedia.org/wiki/Dice
 * Class: Fall - COSC 1437.83003
 * Assignment1: Die
 * Date: 02/06/2018
 * @author Lars Van der Zande
 * @version 1.0.0
 *
 */
public class Die {
    private int sides, value;

    /**
     * Creates a Die object
     * @param numberOfSides the number of sides on this Die object
     */
    public Die(int numberOfSides) {
        this.sides = numberOfSides;
        roll();
    }

    /**
     * Generates a random number between 1 and the number of sides on the die.
     */
    public void roll() {
        java.util.Random rand = new java.util.Random();
        this.value = rand.nextInt(this.sides) +1;
    }

    /**
     * Simple getter method to retrieve the number of sides this die has.
     * @return the number of sides on this die
     */
    public int getSides() {return this.sides;}

    /**
     * Simple getter method to retrieve the previously rolled value of this die.
     * @return the value of the die after the die was rolled
     */
    public int getValue() {return this.value;}

}
