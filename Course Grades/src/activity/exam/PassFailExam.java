package activity.exam;

import activity.PassFailActivity;

/**
 * Description: Class to describe the score, grade, and name of an Pass/Fail Exam. Extends activity.PassFailActivity.
 * Assignment: course Grades
 * Class: COSC 1437.83003
 * Date: April 19, 2018
 * @author Lars Van der Zande
 * @version 0.0.1
 */
public class PassFailExam extends PassFailActivity {
    /**
     * two arg constructor, sets the grade of the activity and copies attributes from template activity object
     * @param grade grade.Grade object, stores the score and letter grade
     * @param activity activity.Activity object, stores details about the activity
     */
    public PassFailExam(grade.Grade grade, activity.Activity activity) {
        super(grade, activity);
    }
}
