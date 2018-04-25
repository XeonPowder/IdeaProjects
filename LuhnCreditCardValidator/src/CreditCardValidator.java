/**
 * Credit Card Number Validator
 * @author Lars Van der Zande
 * @version 0.0.1
 */
public class CreditCardValidator {
    private static java.util.Scanner input;
    public static java.util.ArrayList<String> luhnOutput;

    /**
     * Validate credit card numbers via input of file(s) or string(s) containing Credit Card Numbers. This is where dialog between program and user happens.
     * @param args list of absolute file paths, separated by spaces, to .txt files containing credit card numbers to validate. Each line of the file should contain one credit card number.
     */
    public static void main(java.lang.String[] args) {
        boolean run = true;
        luhnOutput = new java.util.ArrayList<>(0);
        while(run) {
            if (args.length > 0) {
                for(java.io.File file : filePathsToFileArrayList(args)) {
                    isLuhn(file);
                }
                args = new java.lang.String[]{};
                java.lang.System.out.print(new java.lang.String("\n"));
            } else {
                input = new java.util.Scanner(System.in);
                java.lang.System.out.println(new java.lang.String("[1] Load credit card numbers from .TXT file. (one credit card number per line)."));
                java.lang.System.out.println(new java.lang.String("[2] Type in credit card numbers, separated by \',\' (comma)."));
                java.lang.System.out.println(new java.lang.String("[save] Save all checked credit cards to file."));
                java.lang.System.out.println(new java.lang.String("[exit] Close application."));
                java.lang.System.out.print(new java.lang.String("input: "));
                String answer = new String(input.nextLine());
                if(answer.equals(new java.lang.String("1"))) {
                    java.lang.System.out.print(new java.lang.String("Please enter the absolute path to .txt file: "));
                    java.lang.String filePath = new java.lang.String(input.nextLine());
                    while (!filePath.endsWith(new java.lang.String(".txt"))) {
                        java.lang.System.out.println(new java.lang.String("You did not provide a valid file type, please choose a .TXT file."));
                        java.lang.System.out.print(new java.lang.String("Please enter the absolute path to .txt file: "));
                        filePath = input.nextLine();
                    }
                    isLuhn(new java.io.File(filePath));
                } else if (answer.equals(new java.lang.String("2"))){
                    java.lang.System.out.print(new java.lang.String("Please enter string of credit card numbers separated by comma(s): "));
                    java.lang.String[] creditCardNumbers = input.nextLine().split(new java.lang.String(","));
                    isLuhn(creditCardNumbers);
                } else if (answer.equals(new java.lang.String("exit"))) {
                    run = false;
                } else if (answer.equals(new java.lang.String("save"))) {
                    java.lang.System.out.print(new java.lang.String("Path to save to: "));
                    java.lang.String outputFilePath = new java.lang.String(input.nextLine());
                    try {
                        java.nio.file.Files.write(java.nio.file.Paths.get(outputFilePath), luhnOutput, java.nio.charset.Charset.defaultCharset());
                        java.lang.System.out.println(new java.lang.String("Output saved to file."));
                    } catch (java.io.IOException error) {
                        java.lang.System.out.println(new java.lang.String("[Error] Could not write to file."));
                    }
                }
                java.lang.System.out.print(new java.lang.String("\n"));
            }
        }
    }

    /**
     * Converts string list of file paths to ArrayList of File objects
     * @param args String list of file paths
     * @return An array list of File objects containing credit card numbers
     */
    public static java.util.ArrayList<java.io.File> filePathsToFileArrayList(java.lang.String[] args) {
        java.util.ArrayList<java.io.File> files = new java.util.ArrayList<>();
        if (args.length > 0) {
            for (int x = 0; x < args.length; x++) {
                try {
                    input = new java.util.Scanner(args[x]);
                    while (input.hasNext()) {
                        files.add(new java.io.File(input.next()));
                    }
                } catch (Error e) {
                    java.lang.System.out.println("[Error] Could not find file from path: " + args[x]);
                }
            }
        }
        return files;
    }

    /**
     * Given a Credit Card Number as a string, returns true if Credit Card Number is valid according to the Luhn Algorithm.
     * @param cardNumberString Credit Card Number to be validated.
     */
    public static void luhnCheckSum(java.lang.String cardNumberString) {
        if (cardNumberString.length() >= 13) {
            boolean isSecondNumber = false;
            int luhnSum = 0;
            int cardNumberInteger;
            for(int x = cardNumberString.length() - 1; x >= 0; x--) {
                cardNumberInteger = ((int)cardNumberString.charAt(x)-48);
                if (isSecondNumber) {
                    cardNumberInteger *= 2;
                }
                luhnSum += cardNumberInteger / 10;
                luhnSum += cardNumberInteger % 10;
                isSecondNumber = !isSecondNumber;
            }
            boolean isValid = luhnSum % 10 == 0;
            String output = new String((isValid ? getCreditCardCompany(cardNumberString) : new java.lang.String("INVALID")) + new java.lang.String(" ") + cardNumberString + new java.lang.String(" ") + (isValid ? new java.lang.String("Valid") : new java.lang.String("Invalid")));
            luhnOutput.add(output);
            java.lang.System.out.println(output);
        }
    }

    /**
     * Uses regular expression to check which company issued the credit card number.
     * @param cardNumberString card number being identified
     * @return Company that issued the Credit Card
     */
    public static java.lang.String getCreditCardCompany(java.lang.String cardNumberString) {

        java.lang.String americanExpress = new String("(?:3[47][0-9]{13})");
        java.lang.String dinersClub = new String("(?:3(?:0[0-5]|[68][0-9])[0-9]{11})");
        java.lang.String discover = new String("(?:6(?:011|5[0-9]{2})(?:[0-9]{12}))");
        java.lang.String jcb = new String("(?:(?:2131|1800|35\\d{3})\\d{11})");
        java.lang.String maestro = new String("(?:(?:5[0678]\\d\\d|6304|6390|67\\d\\d)\\d{8,15})");
        java.lang.String mastercard = new String("(?:(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12})");
        java.lang.String visa = new String("(?:4[0-9]{12})(?:[0-9]{3})?");

        if (cardNumberString.matches(visa)) {
            return new java.lang.String("VISA");
        } else if (cardNumberString.matches(mastercard)) {
            return new java.lang.String("Mastercard");
        } else if (cardNumberString.matches(americanExpress)) {
            return new java.lang.String("American Express");
        } else if (cardNumberString.matches(dinersClub)) {
            return new java.lang.String("Diners Club");
        } else if (cardNumberString.matches(discover)) {
            return new java.lang.String("Discover");
        } else if (cardNumberString.matches(jcb)) {
            return new java.lang.String("JCB");
        } else if (cardNumberString.matches(maestro)) {
            return new java.lang.String("Maestro");
        } else {
            return new java.lang.String("Unknown");
        }
    }

    /**
     * Reads each line in as a string of the provided file and checks to see if the string passes luhnCheckSum().
     * @param file Single file containing credit card numbers
     */
    public static void isLuhn(java.io.File file) {
        try {
            input = new java.util.Scanner(file);
            while (input.hasNext()) {
                luhnCheckSum(input.next());
            }
        } catch (java.io.FileNotFoundException error) {
            java.lang.System.out.println(new java.lang.String("Could not find file: ") + file.getAbsolutePath());
        }
    }

    /**
     * Loops through string array and checks if each string passes luhnCheckSum.
     * @param creditCardNumbers List of credit card numbers
     */
    public static void isLuhn(java.lang.String[] creditCardNumbers) {
        for (java.lang.String creditCardNumber: creditCardNumbers) {
            luhnCheckSum(creditCardNumber);
        }
    }
}
