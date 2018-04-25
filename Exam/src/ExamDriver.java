public class ExamDriver {
    public static void main(String[] args) {
        System.out.print("Enter test score: ");
        System.out.println("\nYour letter grade is: " + Exam.calculateLetterGrade(new java.util.Scanner(System.in).nextLine()));
    }
}
