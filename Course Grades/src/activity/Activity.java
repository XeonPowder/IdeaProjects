package activity;

/**
 * Description: Class to describe the activity registered in a course.
 * Assignment: course Grades
 * Class: COSC 1437.83003
 * Date: April 19, 2018
 * @author Lars Van der Zande
 * @version 0.0.1
 */
public class Activity {
    /**
     * Used to differentiate activities
     */
    public enum ActivityType {
        ACTIVITY,
        GRADED_ACTIVITY,
        PASS_FAIL_ACTIVITY,
        FINAL_EXAM,
        PASS_FAIL_EXAM,
        LAB,
        ESSAY
    }

    private java.util.UUID uuid;
    private String activityName;
    private double pointsPerQuestion;
    private int numberOfQuestions;
    private ActivityType activityType;

    /**
     * two arg constructor, sets activity name, activity type, and generates a universally unique identifier
     * @param activityName String, the name of this activity
     * @param activityType activity.Activity.ActivityType enum, the type of this activity
     */
    public Activity(String activityName, ActivityType activityType) {
        this.uuid = java.util.UUID.randomUUID();
        this.activityName = (activityName.length() == 0) ? "Activity" : activityName;
        this.activityType = activityType;
    }

    /**
     * three arg constructor, sets activity name, activity type, number of questions, and generates a universally unique identifier
     * @param activityName String, the name of this activity
     * @param activityType activity.Activity.ActivityType enum, the type of this activity
     * @param numberOfQuestions primitive int, the number of questions in this activity
     */
    public Activity(String activityName, ActivityType activityType, int numberOfQuestions) {
        this(activityName, activityType);
        this.pointsPerQuestion = (double)(100 / numberOfQuestions);
        this.numberOfQuestions = numberOfQuestions;
    }

    /**
     * three arg constructor, sets activity name, activity type, number of questions, and generates a universally unique identifier
     * @param activityName String, the name of this activity
     * @param activityType activity.Activity.ActivityType enum, the type of this activity
     * @param pointsPerQuestion primitive double, the number of points each question is worth for this activity
     */
    public Activity(String activityName, ActivityType activityType, double pointsPerQuestion) {
        this(activityName, activityType);
        this.pointsPerQuestion = pointsPerQuestion;
        this.numberOfQuestions = (int)(100 / pointsPerQuestion);
    }

    /**
     * copy constructor, copies a Activity object parameter to this new Activity object
     * @param activity activity.Activity, object to copy from
     */
    public Activity(Activity activity) {
        this.uuid = activity.uuid;
        this.activityName = activity.activityName;
        this.pointsPerQuestion = activity.pointsPerQuestion;
        this.numberOfQuestions = activity.numberOfQuestions;
        this.activityType = activity.activityType;
    }

    /**
     * Return the Universally Unique Identifier associated to this object
     * @return java.util.UUID object, always unique
     */
    public java.util.UUID getUuid() {
        return this.uuid;
    }

    /**
     * Returns the name of this object's activity as a String.
     * @return String, name of this activity that has been graded.
     */
    public String getActivityName() {
        return this.activityName;
    }

    /**
     * Returns the number of points per question for this Activity object
     * @return primitive double
     */
    public double getPointsPerQuestion() {
        return this.pointsPerQuestion;
    }

    /**
     * Returns the number of questions for this Activity object
     * @return primitive int
     */
    public int getNumberOfQuestions() {
        return this.numberOfQuestions;
    }

    /**
     * Given the number of questions correct for this Activity, return a grade.Grade object
     * @param numberOfQuestionsCorrect
     * @return grade.Grade object, contains score, letter grade, and weight
     */
    public grade.Grade gradeActivity(int numberOfQuestionsCorrect) {
        return new grade.Grade((numberOfQuestionsCorrect / numberOfQuestions )*100);
    }

    /**
     * Returns the activity.Activity.ActivityType associated with this Activity object.
     * @return activity.Activity.ActivityType enum, the type of this activity
     */
    public ActivityType getActivityType() {
        return this.activityType;
    }
}
