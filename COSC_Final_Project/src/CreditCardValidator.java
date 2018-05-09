/**
 * Credit Card Number Validator
 * Description: This program validates credit card numbers.
 * Class: Spring - COSC 1437.83003
 * FinalProject: Luhn Algorithm Credit Card Validator
 * Date: 08/15/2011
 * @author Lars Van der Zande
 * @version 0.0.1
 */
public class CreditCardValidator {
    private static java.util.Scanner input;
    private static java.util.ArrayList<String> valid;
    private static java.util.ArrayList<String> invalid;

    /**
     * Validate credit card numbers via input of file(s) or string(s) containing Credit Card Numbers. This is where dialog between program and user happens.
     * @param args list of absolute file paths, separated by spaces, to .txt files containing credit card numbers to validate. Each line of the file should contain one credit card number.
     */
    public static void main(java.lang.String[] args) {

        boolean run = true;
        valid = new java.util.ArrayList<>(0);
        invalid = new java.util.ArrayList<>(0);
        java.util.Date now = new java.util.Date();
        valid.add(0, "\n"+now+"\n");
        invalid.add(0, "\n"+now+"\n");
        while(run) {
            if (args != null && args.length > 0) {
                for(java.io.File file : filePathsToFileArrayList(args)) {
                    isLuhn(file);
                }
                args = null;
                java.lang.System.out.print(new java.lang.String("\n"));
            } else {
                String answer = "start";
                while (!answer.equals(new java.lang.String("exit"))) {
                    input = new java.util.Scanner(System.in);
                    java.lang.System.out.print(new java.lang.String("\n"));
                    java.lang.System.out.println(new java.lang.String("[1] Load credit card numbers from .TXT file. (one credit card number per line)."));
                    java.lang.System.out.println(new java.lang.String("[2] Type in credit card numbers, separated by \',\' (comma)."));
                    java.lang.System.out.println(new java.lang.String("[save] Save all checked credit cards to file."));
                    java.lang.System.out.println(new java.lang.String("[clear cache] Removes invalid and valid credit card numbers from memory."));
                    java.lang.System.out.println(new java.lang.String("[exit] Close application."));
                    java.lang.System.out.print(new java.lang.String("input: "));
                    answer = new java.lang.String(input.nextLine()).toLowerCase();
                    java.lang.System.out.print(new java.lang.String("\n"));
                    System.out.println("Answer: " + answer);
                    if (answer.equals("clear cache") || answer.equals("clear")) {
                        System.out.println("old size: \n\tValid Card Numbers Cached: "+ (valid.size()-1) + "\n\tInvalid Card Numbers Cached: " + (invalid.size()-1));
                        valid.removeAll(valid);
                        invalid.removeAll(invalid);
                        now = new java.util.Date();
                        valid.add(0, "\n"+now+"\n");
                        invalid.add(0, "\n"+now+"\n");
                        System.out.println("new size: \n\tValid Card Numbers Cached: "+ (valid.size()-1) + "\n\tInvalid Card Numbers Cached: " + (invalid.size()-1));

                        continue;
                    } else if(answer.equals(new java.lang.String("1"))) {
                        java.lang.System.out.println(new java.lang.String("type 'exit' to return back to options menu."));
                        java.lang.System.out.print(new java.lang.String("Please enter the absolute path to .txt file: "));
                        java.lang.String filePath = new java.lang.String(input.nextLine());
                        if (filePath.equals("exit")) continue;
                        while (!filePath.endsWith(new java.lang.String(".txt"))) {
                            java.lang.System.out.println(new java.lang.String("You did not provide a valid file type, please choose a .TXT file."));
                            java.lang.System.out.print(new java.lang.String("Please enter the absolute path to .txt file: "));
                            filePath = input.nextLine();
                        }
                        isLuhn(new java.io.File(filePath));
                    } else if (answer.equals(new java.lang.String("2"))){
                        java.lang.System.out.println(new java.lang.String("type 'exit' to return back to options menu."));
                        java.lang.System.out.print(new java.lang.String("Please enter string of credit card numbers separated by comma(s): "));
                        String numbers = input.nextLine();
                        if (numbers.equals("exit")) continue;
                        java.lang.String[] creditCardNumbers = numbers.split(new java.lang.String(","));
                        isLuhn(creditCardNumbers);
                    } else if (answer.equals(new java.lang.String("exit"))) {
                        answer = "exit";
                        continue;
                    } else if (answer.equals(new java.lang.String("save"))) {
                        java.lang.System.out.println(new java.lang.String("files will be written to the \'out\' folder."));
                        try {
                            String[] outputFilePaths = {"out/valid_cards.txt","out/invalid_numbers.txt"};
                            java.lang.System.out.println(new java.lang.String("destination: "));
                            for (String outputFilePath : outputFilePaths) {

                                java.nio.file.Files.write(java.nio.file.Paths.get(outputFilePath), (outputFilePath.contains("invalid") ? invalid : valid), java.nio.charset.Charset.defaultCharset(), java.nio.file.StandardOpenOption.CREATE, (java.nio.file.Files.exists(java.nio.file.Paths.get(outputFilePath)) ? java.nio.file.StandardOpenOption.APPEND : java.nio.file.StandardOpenOption.TRUNCATE_EXISTING), java.nio.file.StandardOpenOption.WRITE);
                                java.lang.System.out.println(new java.lang.String("\t" + java.nio.file.Paths.get("./"+outputFilePath)));
                            }
                        } catch (java.io.IOException error) {
                            java.lang.System.out.println(new java.lang.String("[Error] Could not write to file."));
                        }
                    }
                }
                run = false;
            }
        }
    }

    /**
     * Converts string list of file paths to ArrayList of File objects
     * @param args String list of file paths
     * @return An array list of File objects containing credit card numbers
     */
    public static java.util.ArrayList<java.io.File> filePathsToFileArrayList(java.lang.String[] args) {
        java.util.ArrayList<java.io.File> files = new java.util.ArrayList<>(0);
        if (args.length > 0) {
            for (int x = 0; x < args.length; x++) {
                try {
                    java.util.Scanner fileList = new java.util.Scanner(args[x]);
                    while (fileList.hasNext()) {
                        files.add(new java.io.File(fileList.next()));
                    }
                } catch (Exception e) {
                    java.lang.System.out.println("[Error] Could not find input file from path: " + args[x]);
                }
            }
        }
        return files;
    }

    /**
     * Given a Credit Card Number as a string, check to see if the card number passes the luhn check sum algorithm.
     * Adds credit card number to valid array if the number is valid, and to the invalid array if invalid.
     * Outputs to console whether or not the credit card number is valid or invalid. If valid, output corresponding credit card issuer.
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
            if (isValid) valid.add(output);
            else invalid.add(output);
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
        java.lang.String bankCard = new String("(?:(5610[0-9]{12}|56022[12345][0-9]{10}))");
        java.lang.String chinaUnionPay = new String("(?:62[0-9]{14,17})");
        java.lang.String ruPay = new String("(?:6(0[0-9]{14}|521[0-9]{12})");
        java.lang.String interPayment = new String("(?:636[0-9]{13})");
        java.lang.String dankort = new String("(?:5019[0-9]{12})");
        java.lang.String mir = new String("(?:220(?:[01234])[0-9]{12})");
        java.lang.String switchCard = new String("^(4903|4905|4911|4936|6333|6759)[0-9]{12}|(4903|4905|4911|4936|6333|6759)[0-9]{14}|(4903|4905|4911|4936|6333|6759)[0-9]{15}|564182[0-9]{10}|564182[0-9]{12}|564182[0-9]{13}|633110[0-9]{10}|633110[0-9]{12}|633110[0-9]{13}$");
        java.lang.String solo = new String("^(6334|6767)[0-9]{12}|(6334|6767)[0-9]{14}|(6334|6767)[0-9]{15}$");
        java.lang.String verve = new String("((?:506099|5061[0-8][0-9]|50619[0-8]|65000[2-9]|65001[0-9]|65002[0-7])[0-9]{10,13})");
        java.lang.String troy = new String("(?:9792[0-8][0-9]{11})");
        java.lang.String dinersClubCarteBlanche = new String("(?:3(?:0[0-5]|[68][0-9])[0-9]{11})");
        java.lang.String dinersClubInternational = new String("(?:36[0-9]{12})");
        java.lang.String dinersClubUSAandCanada = new String("(?:54[0-9]{14})");
        java.lang.String discover = new String("^6(?:011[0-9]{12,15}|22(?:1(?:2[6-9][0-9]{10}|[3-9][0-9]{11})|[2-8][0-9]{12}|9(?:[01][0-9][0-9]{10,13}|2[0-5][0-9]{10,13}))|4[4-9]{1}[0-9]{13,16}|5[0-9]{14,17})");
        java.lang.String instaPayment = new String("(?:63[789][0-9]{13})");
        java.lang.String jcb = new String("(?:3[13]\\d{14})");
        java.lang.String laser = new String("(?:6[37][07][4619][0-9]{12})");
        java.lang.String maestro = new String("(?:(?:5[0678][0-9][0-9]|6304|6390|67[0-9][0-9])[0-9]{8,15})");
        java.lang.String mastercard = new String("(?:(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12})");
        java.lang.String visa = new String("(?:4[0-9]{12})(?:[0-9]{3})?");
        java.lang.String visaElectron = new String("(?:4[01589][27041][658437][0-9]{12})");

        if (cardNumberString.matches(visa)) {
            return new java.lang.String("VISA");
        } else if (cardNumberString.matches(mastercard)) {
            return new java.lang.String("Mastercard");
        } else if (cardNumberString.matches(americanExpress)) {
            return new java.lang.String("American Express");
        } else if (cardNumberString.matches(dinersClubCarteBlanche)) {
            return new java.lang.String("Diners Club Carte Blanche");
        } else if (cardNumberString.matches(dinersClubInternational)) {
            return new java.lang.String("Diners Club Internationl");
        } else if (cardNumberString.matches(dinersClubUSAandCanada)) {
            return new java.lang.String("Diners Club USA/Canada");
        } else if (cardNumberString.matches(discover)) {
            return new java.lang.String("Discover");
        } else if (cardNumberString.matches(jcb)) {
            return new java.lang.String("JCB");
        } else if (cardNumberString.matches(maestro)) {
            return new java.lang.String("Maestro");
        } else if (cardNumberString.matches(instaPayment)) {
            return new java.lang.String("InstaPayment");
        } else if (cardNumberString.matches(laser)) {
            return new java.lang.String("Laser");
        } else if (cardNumberString.matches(visaElectron)) {
            return new java.lang.String("Visa Electron");
        } else if (cardNumberString.matches(bankCard)) {
            return new java.lang.String("Bankcard");
        }  else if (cardNumberString.matches(chinaUnionPay)) {
            return new java.lang.String("China UnionPay");
        }  else if (cardNumberString.matches(ruPay)) {
            return new java.lang.String("RuPay");
        }  else if (cardNumberString.matches(interPayment)) {
            return new java.lang.String("InterPayment");
        }  else if (cardNumberString.matches(dankort)) {
            return new java.lang.String("Dankort");
        }  else if (cardNumberString.matches(mir)) {
            return new java.lang.String("MIR");
        }  else if (cardNumberString.matches(verve)) {
            return new java.lang.String("Verve");
        }  else if (cardNumberString.matches(troy)) {
            return new java.lang.String("Troy");
        }  else if (cardNumberString.matches(switchCard)) {
            return new java.lang.String("Switch");
        }  else if (cardNumberString.matches(solo)) {
            return new java.lang.String("Solo");
        }  else {
            return new java.lang.String("Unknown");
        }
    }

    /**
     * Reads each line of the file into the program as a string and check to see if each string passes luhnCheckSum().
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

    /**
     * Used to get a readonly copy of the valid credit card number array list.
     * @return java.util.List containing String objects, readonly copy of Credit Card number array list
     */
    public static java.util.List<String> getValidCardNumbersAsStringArrayList() {
        return java.util.Collections.unmodifiableList(valid);
    }

    /**
     * Used to get a readonly copy of the invalid credit card number array list.
     * @return java.util.List containing String objects, readonly copy of Credit Card number array list
     */
    public static java.util.List<String> getInvalidCardNumbersAsStringArrayList() {
        return java.util.Collections.unmodifiableList(invalid);
    }
}
