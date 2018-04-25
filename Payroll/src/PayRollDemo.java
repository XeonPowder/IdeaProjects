public class PayRollDemo {

    public static Payroll payRoll = new Payroll();

    public static void main(String[] args) {
        while(manageEmployees());
    }

    public static boolean manageEmployees() {
        displayEmployeeIdList();
        return editEmployee(selectEmployeeById());
    }

    private static boolean editEmployee(Employee employee) {
        System.out.printf("\n[Employee - %d]\n", employee.getIdentifier());
        System.out.println("[1] : change hours");
        System.out.println("[2] : change pay rate");
        System.out.println("[3] : display wage");
        System.out.println("[4] : back");
        System.out.println("[5] : exit");
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Please enter a number [1-5]: ");
        int option = input.nextInt();
        switch(option) {
            case 1:
                System.out.printf("\n[Employee - %d] ", employee.getIdentifier());
                System.out.print("Enter new hours: ");
                int hours = input.nextInt();
                while (hours < 0) {
                    System.out.printf("\n[Employee - %d] ", employee.getIdentifier());
                    System.out.print("Enter new non-negative hours: ");
                    hours = input.nextInt();
                }
                employee.setHours(hours);
                return editEmployee(employee);
            case 2:
                System.out.printf("\n[Employee - %d] ", employee.getIdentifier());
                System.out.print("Enter new pay Rate: ");
                int payRate = input.nextInt();
                while (payRate < 6) {
                    System.out.printf("\n[Employee - %d] ", employee.getIdentifier());
                    System.out.print("Enter new pay Rate (greater than ~5.99): ");
                    payRate = input.nextInt();
                }
                employee.setPayRate(payRate);
                return editEmployee(employee);
            case 3:
                System.out.printf("\n[Employee - %d] ", employee.getIdentifier());
                System.out.printf("Gross Pay: %.2f\n", employee.getWage());
                return editEmployee(employee);
            case 4:
                displayEmployeeIdList();
                return editEmployee(selectEmployeeById());
            case 5:
                return false;
            default:
                return editEmployee(employee);
        }

    }

    public static void displayEmployeeIdList() {
        System.out.print("\nEmployee ID List: ");
        for(Integer eId : Payroll.employeeIds) {
            if (Payroll.employeeIds.indexOf(eId) != Payroll.employeeIds.size()-1) {
                System.out.print(eId + ", ");
            } else {
                System.out.print(eId + ".\n");
            }
        }
    }

    public static Employee selectEmployeeById() {
        System.out.print("Please select an Employee by ID: ");
        java.util.Scanner input = new java.util.Scanner(System.in);
        int eId = input.nextInt();
        while (Payroll.employeeIds.indexOf(eId) == -1) {
            System.out.print("Please select a valid Employee by ID: ");
            eId = input.nextInt();
        }
        return payRoll.getEmployee(eId);
    }
}
