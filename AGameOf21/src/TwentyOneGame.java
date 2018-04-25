/**
 * Allows for the user of this application to play a game of 21. To win the game, the user must obtain a score that is greater than the computer, and is less than or equal to 21.
 * @author Lars Van der Zande
 * @version 1.0.0
 */
public class TwentyOneGame {
    private static final int NUM_SIDES = 6;
    private static final int WINNING_TOTAL = 21;
    private static final String WON = "You won!";
    private static final String LOST = "You lost.";
    private static final String outputFilePath = System.getProperty("user.dir")+"/output.txt";
    private static final java.io.File inputFile = new java.io.File(System.getProperty("user.dir")+ "/input.txt");
    private static final java.util.Scanner input = new java.util.Scanner(System.in);

    private static int computerScore =0;
    private static int userScore = 0;
    private static java.util.ArrayList<String> outputLines = new java.util.ArrayList<String>();

    /**
     * This method runs the game of 21.
     * @param args not used.
     */
    public static void main(String[] args) {
        Die die1 = new Die(NUM_SIDES); // declare and construct die 1
        Die die2 = new Die(NUM_SIDES); // declare and construct die 2

        outputLines.add("\n\nTime Played: "+ java.util.Calendar.getInstance().getTime()); // add the current dateTime to the list of strings to be outputted to file.

        try{
            java.util.Scanner inputFileReader = new java.util.Scanner(inputFile); // Scanner reads through the file
            while(inputFileReader.hasNextLine()) { // While there is still a next
                System.out.print(inputFileReader.nextLine()); // print that next
            }
            inputFileReader.close(); // close the open InputStream
            System.out.print("\n"); // clean up the console output with new line
        } catch (Exception e) {
            System.out.println("Could not read from file \"input.txt\"."); // throws FileNotFoundException
        }

        char again; // declare sentential variable

        do {

            if (userScore > 0) {
                System.out.println("Your Score: " + userScore); //display user's score only if rolled already
            }
            System.out.print("Would you like to roll the dice (y/n)? "); //ask user to role a die
            again = input.next().charAt(0); // get the input from the user
            if (Character.toUpperCase(again) == 'Y') { //check if the user wants to roll the die
                die1.roll(); //roll die 1
                die2.roll(); //roll die 2
                userScore += die1.getValue()+die2.getValue(); //update user's total score by adding the values of the dice recently rolled

                die1.roll(); //roll die 1
                die2.roll(); //roll die 2
                computerScore += die1.getValue()+die2.getValue(); //update computer's score
            }
        } while (Character.toUpperCase(again) == 'Y' && userScore < WINNING_TOTAL); // if user's score is still under 21, and user wants to still roll the dice

        String userScore = "Your Score: "+ TwentyOneGame.userScore; // String variable to hold user's score
        String computerScore = "Computer Score: "+ TwentyOneGame.computerScore; //String variable to hold computer's score

        outputLines.add(userScore); // Add the score String to the list of strings to be added to the output file.
        outputLines.add(computerScore); // Add the score String to the list of strings to be added to the output file.

        System.out.println(userScore); // Print out the user's score
        System.out.println(computerScore); //Print out the computer's score

        if (TwentyOneGame.userScore <= WINNING_TOTAL) { //user's score less than 22
            if (TwentyOneGame.userScore > TwentyOneGame.computerScore || TwentyOneGame.computerScore > WINNING_TOTAL) { // user's score is better than the computer's score
                outputLines.add(WON); // add the 'WON' String to be outputted to file.
                System.out.println(WON); // tell the user that he has won.
            } else {
                outputLines.add(LOST); // add the 'LOST' String to be outputted to file.
                System.out.println(LOST); // tell the user that he has lost.
            }
        } else {
            outputLines.add(LOST); // add the 'LOST' String to be outputted to the file.
            System.out.println(LOST); // tell the user that he has lost.
        }


        java.io.File outputFile = new java.io.File(outputFilePath); // declare and construct a new File object

        try{
            java.io.FileWriter outputFileWriter = new java.io.FileWriter(outputFile, true); //declare and construct a new FileWriter object, with the second parameter set to true, to allow for appending to the file.
            for(String output : outputLines) { // loop through the Strings that are in the ArrayList, each string will be assigned to the same variable output, just one after each other.
                outputFileWriter.write(output+"\n"); // write out the current indexed string
            }
            outputFileWriter.close(); // close the FileWriter
        } catch (Exception e) {
            System.out.println("Could not write to file \"output.txt\""); // Tell the user that the output file could not be written to.
        }

        System.out.println("The game is over, thank you for playing.\nAn output file has been saved here: "+outputFilePath); // Tell the user that the game is over and where to find the output file.

        System.exit(0); // close the application
    }
}
