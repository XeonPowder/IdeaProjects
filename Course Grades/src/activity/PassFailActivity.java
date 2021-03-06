package activity;

/**
 * Description: Class to describe the score, grade, and name of a Pass/Fail Activity. Extends activity.GradedActivity.
 * Assignment: course Grades
 * Class: COSC 1437.83003
 * Date: April 19, 2018
 * @author Lars Van der Zande
 * @version 0.0.1
 */
public class PassFailActivity extends GradedActivity {
    /**
     * two arg constructor, sets the grade of the activity and copies attributes from template activity object
     * @param grade grade.Grade object, stores the score and letter grade
     * @param activity activity.Activity object, stores details about the activity
     */
    public PassFailActivity(grade.Grade grade, Activity activity) {
        super(grade, activity);
    }
}
