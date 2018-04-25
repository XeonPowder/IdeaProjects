/**
 * Description: This Class allows for converting of [0-9a-zA-Z,.?] to Morse Code.
 * Class: Spring - COSC 1437.83003
 * Assignment9: Morse Code
 * Date: 04/12/2018
 * @author Lars van der Zande
 * @version 0.0.1
 */
public class MorseCode {
    private String original;
    private String mCode;
    private final String regular = " ,.?0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String[] morseCodes = {" ", "--••--", "•-•-•-", "••--••", "-----", "•----", "••---", "•••--", "••••-", "•••••", "-••••", "--•••", "---••", "----•", "•-", "-•••", "-•-•", "-••", "•", "••-•", "--•", "••••", "••", "•----", "-•-", "•-••", "--", "-•", "---", "•--•", "--•-", "•-•", "•••", "-", "••-", "•••-", "•--", "-••-", "-•--", "--••"};

    /**
     * Single parameter constructor, input String is automatically converted to morse code and can be accessed via the getMorseCode() method
     * @param input String, a string of characters which will be converted to morse code
     */
    public MorseCode(String input) {
        this.original = input;
        this.mCode = toMorse(input);
    }

    /**
     * Takes in a String of characters and converts each character into the morse code version of said character.
     * @param input String of characters each of which will be converted to morse code.
     * @return String of Morse Code representing the input.
     */
    public String toMorse(String input) {
        String temp = "";
        for(int x = 0; x < input.length(); x++){
            temp += this.toMorse(Character.toUpperCase(input.charAt(x))) + " ";
        }
        return temp;
    }

    /**
     * Converts a single character to morse code and returns the morse code as a String
     * @param ch Character to be converted to morse code.
     * @return String, Morse Code representation of the character parameter 'ch'.
     */
    public String toMorse(char ch) {
        if (Character.isLowerCase(ch))
            ch = Character.toUpperCase(ch);
        if (regular.indexOf(ch) != -1)
            return morseCodes[regular.indexOf(ch)];
        else
            return "null";
    }

    /**
     * Allows for access to this Object's morse code
     * @return Morse Code representation of the initial String passed as a parameter during the construction of this object.
     */
    public String getMorseCode() {
        return mCode;
    }

    /**
     * Allows for access to this Object's original String before it was converted to Morse Code
     * @return Original String passed as a parameter during the construction of this object.
     */
    public String getOriginal() {
        return original;
    }
}
