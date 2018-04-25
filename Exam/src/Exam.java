public class Exam {
    public static char calculateLetterGrade(int grade) {
        if (grade < 60) {
            return 'F';
        } else if (grade < 70) {
            return 'D';
        } else if (grade < 80) {
            return 'C';
        } else if (grade < 90) {
            return 'B';
        } else {
            return 'A';
        }
    }
    public static char calculateLetterGrade(String grade) {
        return calculateLetterGrade(Integer.parseInt(grade));
    }
}
