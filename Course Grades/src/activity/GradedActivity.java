package activity;

/**
 * Description: Class to describe the score, grade, and name of an activity.
 * Assignment: course Grades
 * Class: COSC 1437.83003
 * Date: April 19, 2018
 * @author Lars Van der Zande
 * @version 0.0.1
 */
public class GradedActivity extends Activity{

    private grade.Grade grade;

    /**
     * two arg constructor, sets the grade of the activity and copies attributes from template activity object
     * @param grade grade.Grade object, stores the score and letter grade
     * @param activity activity.Activity object, stores details about the activity
     */
    public GradedActivity(grade.Grade grade, Activity activity) {
        super(activity);
        this.grade = grade;
    }

    /**
     * Returns the score associated with this activity.GradedActivity object.
     * @return primitive double. Between [0-100] inclusive describing the points received for an assignment.
     */
    public double getScore() {
        return this.grade.getScore();
    }

    /**
     * Return the letter grade associated with the score of this activity.GradedActivity object.
     * @return primitive char. Can be [ 'A', 'B', 'C', 'F' ].
     */
    public char getLetterGrade() {
        return this.grade.getLetterGrade();
    }

    /**
     * Returns a formatted String of the accessible data from this object.
     * @return String, containing the activity: name, grade, and score.
     */
    @Override
    public String toString() {
        String str = "Activity: " + getActivityName() + "\n\tGrade: " + getLetterGrade() + "\n\tScore: ";
        if (getScore() % 1 == 0) {
            str += Integer.parseInt((getScore() + "").split("[.]")[0]);
        } else {
            str += getScore();
        }
        return str + "%\n";
    }
}
