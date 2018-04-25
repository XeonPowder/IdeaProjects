package grade;

/**
 * Description: Class to hold the score, letter grade, and weight of an activity.
 * Assignment: course Grades
 * Class: COSC 1437.83003
 * Date: April 19, 2018
 * @author Lars Van der Zande
 * @version 0.0.1
 */
public class Grade {
    private int weight;
    private score.Score score;
    private char letter;

    /**
     * no arg constructor, defaults to sample values;
     */
    public Grade() {
        this.score = new score.Score();
        this.weight = 1;
        this.letter = 'F';
    }

    /**
     * one arg constructor, defaults weight, sets the numerical score, and the letter grade
     * @param score primitive double, the score received for an activity
     */
    public Grade(double score) {
        this.score = new score.Score(score);
        if (this.score.getScore() < 70) {
            this.letter = 'F';
        } else if (this.score.getScore() < 80) {
            this.letter = 'C';
        } else if (this.score.getScore() < 90) {
            this.letter = 'B';
        } else if (this.score.getScore() <= 100) {
            this.letter = 'A';
        } else {
            this.letter = 'F';
        }
        this.weight = 1;
    }

    /**
     * 2 arg constructor.
     * @param score primitive double, the numerical score of an activity
     * @param weight the weight of an activity
     */
    public Grade(double score, int weight) {
        this.score = new score.Score(score);
        if (this.score.getScore() < 70) {
            this.letter = 'F';
        } else if (this.score.getScore() < 80) {
            this.letter = 'C';
        } else if (this.score.getScore() < 90) {
            this.letter = 'B';
        } else if (this.score.getScore() <= 100) {
            this.letter = 'A';
        } else {
            this.letter = 'F';
        }
        this.weight = weight;
    }

    /**
     * Returns the score of this Grade object.
     * @return primitive double, numerical score of an activity
     */
    public double getScore() {
        return this.score.getScore();
    }

    /**
     * Returns the letter grade based on the score.
     * @return primitive char, possible values: [ 'F', 'C', 'B', 'A' ]
     */
    public char getLetterGrade() {
        return this.letter;
    }
}
