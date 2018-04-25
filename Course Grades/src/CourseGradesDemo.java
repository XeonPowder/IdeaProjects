import activity.Activity;
import activity.essay.Essay;
import activity.exam.FinalExam;
import activity.GradedActivity;
import activity.exam.PassFailExam;

/**
 * Description: Demonstrates class extensions, interfaces, regex, polymorphism
 * Assignment: Course Grades
 * Class: COSC 1437.83003
 * Date: April 19, 2018
 * @author Lars Van der Zande
 * @version 0.0.1
 */
public class CourseGradesDemo{
    /**
     * Demonstrates: CourseGrades Class capabilities.
     * @param args used for passing scores of the 4 activities required by the assignment via command line arguments
     */
    public static void main(String[] args) {
        // mock command line arguments
        if (args.length == 0) args = "91,81,71,-1".split("[,]");
        // define CourseGrades object
        CourseGrades courseGrades;
        // check for command line arguments
        if (args.length == 4 && isValidScore(Double.parseDouble(args[0])) && isValidScore(Double.parseDouble(args[1])) && isValidScore(Double.parseDouble(args[2])) && isValidScore(Double.parseDouble(args[3]))) {
            // if there are 4 arguments and they all are valid scores
            // then assign courseGrades grades using data from command line
            courseGrades = new CourseGrades(
                    new GradedActivity(new grade.Grade(Double.parseDouble(args[0])), new Activity("Lab", Activity.ActivityType.LAB)),
                    new PassFailExam(new grade.Grade(Double.parseDouble(args[1])), new Activity("Pass Fail Exam", Activity.ActivityType.PASS_FAIL_EXAM)),
                    new Essay(new grade.Grade(Double.parseDouble(args[2])), new Activity("Essay", Activity.ActivityType.ESSAY)),
                    new FinalExam(new grade.Grade(Double.parseDouble(args[3])), new Activity("Final Exam", Activity.ActivityType.FINAL_EXAM))
            );
        } else { // arguments passed via command line are not valid

            // define keyboard input via System.in InputStream
            java.util.Scanner input = new java.util.Scanner(System.in);

            // assign CourseGrades object and pass all 4 test/assignments via constructor
            courseGrades = new CourseGrades(
                    new GradedActivity(new grade.Grade(askForScoreOf("Lab", input)), new Activity("Lab", Activity.ActivityType.LAB)),
                    new PassFailExam(new grade.Grade(askForScoreOf("Pass/Fail Exam", input)), new Activity("Pass/Fail Exam", Activity.ActivityType.PASS_FAIL_EXAM)),
                    new Essay(new grade.Grade(askForScoreOf("Essay", input)), new Activity("Essay", Activity.ActivityType.ESSAY)),
                    new FinalExam(new grade.Grade(askForScoreOf("Final Exam", input)), new Activity("Final Exam", Activity.ActivityType.FINAL_EXAM))
            );

            // define activity.GradedActivity object to hold Lab score
            // pass this object to CourseGrades object

            // courseGrades.setLab(new activity.GradedActivity(askForScoreOf("Lab", input), "Lab"));

            // define activity.exam.PassFailExam object (extends activity.GradedActivity) to hold pass/fail exam score
            // pass this object to CourseGrades object

            // courseGrades.setPassFailExam(new activity.exam.PassFailExam(askForScoreOf("Pass/Fail Exam", input)));

            // define activity.essay.Essay object (extends activity.GradedActivity) to hold essay score
            // pass this object to CourseGrades object

            // courseGrades.setEssay(new activity.essay.Essay(askForScoreOf("activity.essay.Essay", input)));

            // define activity.exam.FinalExam object (extends activity.GradedActivity) to hold final exam score
            // pass this object to CourseGrades object

            // courseGrades.setFinalExam(new activity.exam.FinalExam(askForScoreOf("Final Exam", input)));

            // print out grades and scores for each activity in the CourseGrades object courseGrades
        }
        System.out.println("\n" + courseGrades.toString());
    }

    /**
     * Returns true if a primitive Double object is between 0 and 100 inclusive
     * @param score Double, score to be checked for validity
     * @return true if score is between [0-100] inclusive, else false
     */
    private static boolean isValidScore(double score) {
        return (score >= 0 && score <= 100);
    }

    /**
     * Prompts the user to 'Enter score for the ' + assignment, validates the input via isValidScore, and returns the score as a double
     * @param assignment String, the name of the exam/assignment, will be printed out with the prompt for user input.
     * @param input Instance of a java.util.Scanner object, will be used for scanning the answer to the prompt.
     * @return primitive double, A valid score between 0 and 100 inclusive.
     */
    private static double askForScoreOf(String assignment, java.util.Scanner input) {
        System.out.print("Enter score for the " + assignment + ": ");
        double temp = input.nextDouble();
        while (!isValidScore(temp)) {
            System.out.print("Enter score for the " + assignment +" [0-100]: ");
            temp = input.nextDouble();
        }
        return temp;
    }
}
