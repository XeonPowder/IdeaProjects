public class Payroll {
    private double hoursWorked;
    private double payRate;
    public Payroll() {

    }
    public void setHoursWorked(double hours) {
        this.hoursWorked = hours;
    }
    public void setPayRate(double rate) {
        this.payRate = rate;
    }
    public double getGrossPay() {
        double grossPay;
        double overtimePay;
        if (this.hoursWorked > 40) {
            grossPay = 40*this.payRate;
            overtimePay = (hoursWorked - 40 ) *payRate * 1.5;
            grossPay += overtimePay;
        } else {
            grossPay = payRate*hoursWorked;
        }
        return grossPay;
    }
}
