public class GrossPay {
    public static void main(String[] args) {
        double hours;
        double rate;
        Payroll employee = new Payroll();
        System.out.print("How many hours did the employee work? ");
        java.util.Scanner input = new java.util.Scanner(System.in);
        hours = input.nextDouble();
        while (hours < 0) {
            System.out.println("ERROR: Entered a negative number.");
            System.out.print("How many hours did the employee work? ");
            hours = input.nextDouble();
        }
        input.nextLine();

        System.out.print("What is the employee hourly pay rate? ");
        rate = input.nextDouble();
        while (rate < 0) {
            System.out.println("ERROR: Entered a negative number.");
            System.out.print("What is the employee hourly pay rate? ");
            rate = input.nextDouble();
        }
        input.nextLine();

        employee.setHoursWorked(hours);
        employee.setPayRate(rate);

        System.out.printf("The employee's gross pay is $%.2f", employee.getGrossPay());
        System.exit(0);
    }
}
