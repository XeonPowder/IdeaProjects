/**
 * The MonthDays Class allows the user to retrieve the number of days in a certain month while accounting for leap years. Included are 2 functions used for user input retrieval via a console / terminal / command prompt.
 * Class: Spring - COSC 1437.83003
 * Assignment5: MonthDays
 * Date: 02/25/2018
 * @author Lars Van der Zande
 * @version 1.0.0
 */
public class MonthDays {
    private final static String[] MONTHS = {"January","February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private int month, year;
    /**
     * Constructs a new MonthDays object, this object can be used for getting the number of days in a specific month and year.
     * @param month Integer value of a month. Can be between 1 and 12 (inclusive).
     * @param year Integer value of a year. Can be between 0 and the maximum signed int value.
     */
    public MonthDays(int month, int year) {
        this.month = month;
        this.year = year;
    }
    /**
     * Get this month. Retrieves the private month attribute initialized in the constructor
     * @return month associated with this constructed object.
     */
    public int getMonth() {
        return this.month;
    }
    /**
     * Get this year. Retrieves the private year attribute initialized in the constructor
     * @return year associated with this constructed object.
     */
    public int getYear() {
        return this.year;
    }
    /**
     * Get the name of this month.
     * @return name of the month currently associated with this object as a String object.
     */
    public String getMonthName() {
        return MONTHS[(this.month-1)];
    }

    /**
     * Get the number of days of a certain month and year.
     * @return number of days as an integer.
     */
    public int getNumberOfDays() {
        switch (this.month) {
            case 2:
                if (this.year % 100 == 0) {
                    if (this.year % 400 == 0) {
                        return 29;
                    }
                } else if (this.year % 4 == 0){
                    return 29;
                }
                return 28;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return -1;
        }
    }
    /**
     * Until the user enters a valid number in the range of what the program is looking for keep asking for input. In this case for months in a year we want the number to be between [1,12].
     * @param input A Scanner Object, used by this method to read input from a command prompt / console / terminal.
     * @param invalidInput When an java.util.InputMismatchException error is thrown, we want the user to know that they entered invalid data and re-enter valid data. Sending the function back to itself with this flag allows for the programmer to handle multiple cases of user input with minimal code.
     * @throws java.util.InputMismatchException When an user inputs data that is not interpreted as an integer, this Exception is thrown.
     * @return the year inputted by the user of the program through a command prompt / console / terminal.
     */
    public static int getMonthInput(java.util.Scanner input, boolean invalidInput) {
        if (invalidInput) {
            System.out.println("You've not entered a whole number that is between 1 and 12.");
            input.nextLine();
            return getMonthInput(input,false);
        } else {
            try{
                System.out.print("Enter a month (1-12): ");
                int month = input.nextInt();
                while(month < 1 || month > 12) {
                    System.out.println("You've not entered a whole number that is between 1 and 12.");
                    System.out.print("Enter a month (1-12): ");
                    month = input.nextInt();
                }
                return month;
            } catch (java.util.InputMismatchException e) {
                return getMonthInput(input,true);
            }
        }

    }

    /**
     * Until the user enters a valid number in the range of what the program is looking for keep asking for input. In this case for months in a year we want the number to be between [0, MAX_INT].
     * @param input A Scanner Object, used by this method to read input from a command prompt / console / terminal.
     * @param invalidInput When an java.util.InputMismatchException error is thrown, we want the user to know that they entered invalid data and re-enter valid data. Sending the function back to itself with this flag allows for the programmer to handle multiple cases of user input with minimal code.
     * @throws java.util.InputMismatchException When an user inputs data that is not interpreted as an integer, this Exception is thrown.
     * @return a valid year input from the user of the program through a command prompt / console / terminal.
     */
    public static int getYearInput(java.util.Scanner input, boolean invalidInput) {
        if (invalidInput) {
            System.out.println("You've not entered a valid year.");
            input.nextLine();
            return getYearInput(input,false);
        } else {
            try{
                System.out.print("Enter a year: ");
                int year = input.nextInt();
                while(year < 0) {
                    System.out.println("You've not entered a valid year.");
                    System.out.print("Enter a year: ");
                    year = input.nextInt();
                }
                return year;
            } catch (java.util.InputMismatchException e) {
                return getYearInput(input,true);
            }
        }
    }
}
