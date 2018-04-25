/**
 * Description: Demonstration of the MorseCode Class and all of its methods.
 * Class: Spring - COSC 1437.83003
 * Assignment9: Morse Code
 * Date: 04/12/2018
 * @author Lars van der Zande
 * @version 0.0.1
 */
public class MorseCodeDemo {
    public static void main(String[] args) {
        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        System.out.print("Please type in what would you like to convert to morse code: ");
        MorseCode mCode = new MorseCode(keyboard.nextLine());
        System.out.println("Morse Code: " + mCode.getMorseCode());
        System.out.println("Original: " + mCode.getOriginal());
        System.out.println("\nThank you for using the MorseCode Class.");
        System.out.println(mCode.toMorse("Thank you for using the MorseCode Class") + mCode.toMorse('.'));
    }
}
