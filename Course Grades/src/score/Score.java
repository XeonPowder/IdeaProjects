package score;

public class Score {
    private double score;

    public Score() {
        this.score = 0;
    }

    public Score(double score) {
        this.setScore(score);
    }
    /**
     * Checks to see if the primitive double value passed as an argument is between [0-100] inclusive.
     * @param score primitive double. Should be between 0 and 100 inclusive.
     * @return true if parameter `score` is between [0-100] inclusive.
     */
    private boolean isValidScore(double score) {
        return score >= 0 && score <= 100;
    }

    /**
     *
     * @return
     */
    public double getScore() {
        return score;
    }
    /**
     * Sets the score of this activity.GradedActivity object. Can be any decimal number between [0-100] inclusive.
     * @param score primitive double, between [0-100] inclusive describing the points received for an assignment.
     */
    public void setScore(double score) {
        // validate score
        if (isValidScore(score))
            this.score = score;
        else {
            java.util.Scanner input = new java.util.Scanner(System.in);
            double temp = input.nextDouble();
            while(temp < 0 || temp > 100) {
                System.out.print("Please enter a new score between [0-100] inclusive for: ");
                temp = input.nextDouble();
            }
            this.score = temp;
        }
    }
}
