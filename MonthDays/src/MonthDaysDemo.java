/**
 * Demonstrates the capabilities of the MonthDays Class.
 * Class: Spring - COSC 1437.83003
 * Assignment5: MonthDays
 * Date: 02/25/2018
 * @author Lars Van der Zande
 * @version 1.0.0
 */
public class MonthDaysDemo {

    /**
     * Main driver of the demonstration. Demonstrates multiple methods that can be used from the MonthDays Class.
     * @param args not used.
     */
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        MonthDays mDays = new MonthDays(MonthDays.getMonthInput(input,false), MonthDays.getYearInput(input,false));
        System.out.printf("%d days in %s %d", mDays.getNumberOfDays(), mDays.getMonthName(), mDays.getYear());
    }
}
