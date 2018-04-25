/**
 * Description: This program will display Joe's stock market transactions and final net amount of money earned.
 * Class: Fall - COSC 1437.83003
 * Assignment3: Stock Transaction Program
 * Date: 02/6/2018
 * @author  Lars Van der Zande
 * @version 1.0.0
 */
public class StockTransactionProgram {
    /**
     * Calculates the profit or loss for Joe from dealing in the stock market
     * @param args not used
     */
    public static void main(java.lang.String[] args) {

        int shares = 1000;
        double initialSharePrice = 32.87;
        double brokerCommission = .02;
        double sellSharePrice = 33.92;
        double profit = (((shares*sellSharePrice)-(shares*sellSharePrice*brokerCommission)) - ((shares*initialSharePrice)+(shares*initialSharePrice*brokerCommission)));
        java.lang.System.out.println("Joe");
        java.lang.System.out.println(new java.lang.String().format("%-20s $%.2f", "- bought " + shares + " shares", shares*initialSharePrice));
        java.lang.System.out.println(new java.lang.String().format("%-20s $%.2f", "- paid broker", shares*initialSharePrice*brokerCommission));
        java.lang.System.out.println(new java.lang.String().format("%-20s $%.2f", "- sold " + shares + " shares", shares*sellSharePrice));
        java.lang.System.out.println(new java.lang.String().format("%-20s $%.2f", "- paid broker", shares*sellSharePrice*brokerCommission));
        java.lang.System.out.println((profit > 0) ? new java.lang.String().format("%-20s $%.2f", "- profited", profit) : new java.lang.String().format("%-20s $%.2f", "- lost", -1*profit));
        java.lang.System.exit(0);
    }
}
