/**
 * Description: This program will use the user's inputs and implement them into a story.
 * Class: Fall - COSC 1437.83003
 * Assignment3: Word Game
 * Date: 02/6/2018
 * @author Lars Van der Zande
 * @version 1.0.0
 */
public class WordGame {
    /**
     * Creates a story using the input from the user.
     * @param args not used
     * @return N/A
     * @throw not implemented
     */
    public static void main(java.lang.String[] args) {

        java.util.Scanner input = new java.util.Scanner(java.lang.System.in);

        java.lang.System.out.print("Enter name: ");
        java.lang.String name = new java.lang.String(input.nextLine());

        java.lang.System.out.print("Enter age: ");
        java.lang.String age = new java.lang.String(input.nextLine());
        while(Integer.parseInt(age) < 1) {
            java.lang.System.out.print("Enter age greater than 0: ");
            age = new java.lang.String(input.nextLine());
        }

        java.lang.System.out.print("Enter city: ");
        java.lang.String city = new java.lang.String(input.nextLine());

        java.lang.System.out.print("Enter college: ");
        java.lang.String college = new java.lang.String(input.nextLine());

        java.lang.System.out.print("Enter profession: ");
        java.lang.String profession = new java.lang.String(input.nextLine());

        java.lang.System.out.print("Enter animal type: ");
        java.lang.String animalType = new java.lang.String(input.nextLine());

        java.lang.System.out.print("Enter pet's name: ");
        java.lang.String petName = new java.lang.String(input.nextLine());

        java.lang.System.out.println(
            new java.lang.String("There once was a person named ")
            + name
            + new java.lang.String(" who lived in ")
            + city
            + new java.lang.String(". At the age of ")
            + age
            + new java.lang.String(", ")
            + name
            + new java.lang.String(" went to college at ")
            + college
            + new java.lang.String(". ")
            + name
            + new java.lang.String(" graduated and went to work as a ")
            + profession
            + new java.lang.String(". Then, ")
            + name
            + new java.lang.String(" adopted " + ("aeiou".indexOf(Character.toLowerCase(animalType.charAt(0))) != -1 ? "an " : "a "))
            + animalType
            + new java.lang.String(" named ")
            + petName
            + new java.lang.String(". They both lived happily ever after!")
        );
    }
}
