import activity.Activity;

public class CourseManagementDemo {
    public static void main(String[] args) {
        manager.CourseManager cm = new manager.CourseManager();

        // create a new person, register the person, copy the person into a teacher, and register teacher in course
        person.teacher.Teacher teacher = new person.teacher.Teacher("zszabo@dcccd.edu", "Zoltan", "Szabo", "", "", new java.util.Date());
        course.Course cosc1437 = cm.registerCourse(new course.Course("COSC", 1437, 83003, teacher));

        // create a new person, create a student from that person, and register student in course
        cosc1437.getStudentManager().registerStudent(new person.student.Student("student1@student.dcccd.edu", "Student", "1", "", "", new java.util.Date()));
        cosc1437.getStudentManager().registerStudent(new person.student.Student("student2@student.dcccd.edu", "Student", "2", "", "", new java.util.Date()));
        cosc1437.getStudentManager().registerStudent(new person.student.Student("student3@student.dcccd.edu", "Student", "3", "", "", new java.util.Date()));
        cosc1437.getStudentManager().registerStudent(new person.student.Student("student4@student.dcccd.edu", "Student", "4", "", "", new java.util.Date()));
        cosc1437.getStudentManager().registerStudent(new person.student.Student("student5@student.dcccd.edu", "Student", "5", "", "", new java.util.Date()));
        cosc1437.getStudentManager().registerStudent(new person.student.Student("student6@student.dcccd.edu", "Student", "6", "", "", new java.util.Date()));
        cosc1437.getStudentManager().registerStudent(new person.student.Student("student7@student.dcccd.edu", "Student", "7", "", "", new java.util.Date()));
        cosc1437.getStudentManager().registerStudent(new person.student.Student("student8@student.dcccd.edu", "Student", "8", "", "", new java.util.Date()));
        cosc1437.getStudentManager().registerStudent(new person.student.Student("student9@student.dcccd.edu", "Student", "9", "", "", new java.util.Date()));

        // register activities in course
        cosc1437.getActivityManager().registerActivity(new activity.Activity("Lab", activity.Activity.ActivityType.LAB));
        cosc1437.getActivityManager().registerActivity(new activity.Activity("Pass Fail Exam", Activity.ActivityType.PASS_FAIL_EXAM));
        cosc1437.getActivityManager().registerActivity(new activity.Activity("Essay", activity.Activity.ActivityType.ESSAY));
        cosc1437.getActivityManager().registerActivity(new activity.Activity("Final Exam", activity.Activity.ActivityType.FINAL_EXAM));

        // for each student registered in the course create a graded activity for them, and register the graded activity in the course.
        // get student from course, create a new graded activity for student, and register the graded activity in the course.
        for (activity.Activity activity : cosc1437.getActivities()) {
            for (person.student.Student s : cosc1437.getStudents()) {
                switch(activity.getActivityType()) {
                    case GRADED_ACTIVITY:
                    case ACTIVITY:
                        s.getGradeManager().registerGradedActivity(s, new activity.GradedActivity(new grade.Grade(Math.round(((Math.random() * (100 - 60) + 1) + 60) * 100) / 100), activity));
                        break;
                    case LAB:
                        s.getGradeManager().registerGradedActivity(s, new activity.GradedActivity(new grade.Grade(Math.round(((Math.random() * (100 - 60) + 1) + 60) * 100) / 100), activity));
                        break;
                    case ESSAY:
                        s.getGradeManager().registerGradedActivity(s, new activity.essay.Essay(new grade.Grade(Math.round(((Math.random() * (100 - 60) + 1) + 60) * 100) / 100), activity));
                        break;
                    case FINAL_EXAM:
                        s.getGradeManager().registerGradedActivity(s, new activity.exam.FinalExam(new grade.Grade(Math.round(((Math.random() * (100 - 60) + 1) + 60) * 100) / 100), activity));
                        break;
                    case PASS_FAIL_EXAM:
                        s.getGradeManager().registerGradedActivity(s, new activity.exam.PassFailExam(new grade.Grade(Math.round(((Math.random() * (100 - 60) + 1) + 60) * 100) / 100), activity));
                        break;
                    case PASS_FAIL_ACTIVITY:
                        s.getGradeManager().registerGradedActivity(s, new activity.PassFailActivity(new grade.Grade(Math.round(((Math.random() * (100 - 60) + 1) + 60) * 100) / 100), activity));
                        break;
                }
            }
        }

        // for each course display teacher, course details, and each students' grades for each activity registered in the course
        for (course.Course c : cm.getCourses()) {
            // display course and teacher
            System.out.println("Course: "+c.getSubject() + " " + c.getID() + " - " + c.getSection() + "\n\tTeacher: " + c.getTeacher().getFullName());
            // loop through all activities, all students in each activity for the course cosc1437, and print out scores of each student for each student that has a graded activity assigned for the activity.
            for (activity.Activity activity : c.getActivities()) {
                System.out.println("\tActivity: " + activity.getActivityName());
                for (person.student.Student s: c.getStudents()) {
                    activity.GradedActivity gradedLab = s.getGradeManager().getGradedActivity(s, activity.getUuid());
                    System.out.println("\t\tStudent: " + s.getFullName() + "\t\tUUID: " + s.getID() + "\n\t\tGrade: " + "\n\t\t\tScore: "+ gradedLab.getScore() + "%\n\t\t\tLetter Grade: " + gradedLab.getLetterGrade() + "\n");
                }
            }
        }
    }
}
