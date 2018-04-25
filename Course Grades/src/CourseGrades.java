import activity.essay.Essay;
import activity.exam.FinalExam;
import activity.GradedActivity;
import activity.exam.PassFailExam;

/**
 * Description: Used to manage the activities and the their grades
 * Assignment: course Grades
 * Class: COSC 1437.83003
 * Date: April 19, 2018
 * @author Lars Van der Zande
 * @version 0.0.1
 */
public class CourseGrades {
    /**
     * Instantiation.
     * Array of GradedActivity objects.
     */
    private GradedActivity[] grades;

    /**
     * Creates a new CourseGrades object and gives grades a size of 4 GradedActivity objects
     */
    public CourseGrades() {
        grades = new GradedActivity[4];
    }

    /**
     * 4 arg constructor. gives grades a size of 4 GradedActivity objects, and assigns each parameter to its correct slot in grades.
     * the parameters are in order in which they will be in the grades Array
     * @param aLab
     * @param aPassFailExam
     * @param anEssay
     * @param aFinalExam
     */
    public CourseGrades(GradedActivity aLab, PassFailExam aPassFailExam, Essay anEssay, FinalExam aFinalExam) {
        grades = new GradedActivity[] { aLab, aPassFailExam, anEssay, aFinalExam };
    }

    /**
     * Used to set the GradedActivity object at correct array index
     * @param aLab activity.GradedActivity, object that represents a graded activity. GradedActivity extends Activity
     */
    public void setLab(GradedActivity aLab) {
        grades[0] = aLab;
    }

    /**
     * Used to set the GradedActivity object at correct array index
     * @param aPassFailExam a Polymorphed GradedActivity
     */
    public void setPassFailExam(PassFailExam aPassFailExam) {
        grades[1] = aPassFailExam;
    }

    /**
     * Used to set the GradedActivity object at correct array index
     * @param anEssay a Polymorphed GradedActivity
     */
    public void setEssay(Essay anEssay) {
        grades[2] = anEssay;
    }

    /**
     * Used to set the GradedActivity object at correct array index
     * @param aFinalExam a Polymorphed GradedActivity
     */
    public void setFinalExam(FinalExam aFinalExam) {
        grades[3] = aFinalExam;
    }

    /**
     * Used to return a String consisting of all the necessary data as per the assignments' request
     * @return A concat version of all the GradedActivity's toString() method
     */
    @Override
    public String toString() {
        String str = "";
        for (int x = 0; x < grades.length; x++) {
            str += grades[x].toString();
        }
        return str;
    }
}
