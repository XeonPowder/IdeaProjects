package course;

import manager.ActivityManager;
import manager.StudentManager;

public class Course {
    private java.util.UUID uuid;
    private String subject;
    private int id;
    private int section;
    private person.teacher.Teacher teacher;
    private ActivityManager am;
    private StudentManager sm;

    /**
     * 4 arg constructor, sets course subject, course id, course section, and instructing teacher
     * @param subject String, the subject of the course
     * @param id primitive int, the identification number of the course
     * @param section primitive int, the section identification number of the course
     * @param teacher person.teacher.Teacher, the Teacher object associated with the course represents the teacher of the course
     */
    public Course(String subject, int id, int section, person.teacher.Teacher teacher) {
        this.uuid = java.util.UUID.randomUUID();
        this.section = section;
        this.subject = subject;
        this.id = id;
        this.teacher = teacher;
        this.am = new ActivityManager();
        this.sm = new StudentManager();
    }

    /**
     * Returns this course's activity manager. Contains a HashMap of all the activities registered in the course
     * @return manager.ActivityManager, object for managing activities of a course
     */
    public ActivityManager getActivityManager() {
        return this.am;
    }

    /**
     * Returns this course's student manager. Contains a HashMap of all the students registered in the course
     * @return manager.StudentManager, object for managing the students registered in a course
     */
    public StudentManager getStudentManager() {
        return this.sm;
    }

    /**
     * Returns all activities registered in this course as a Collection of activity.Activity objects
     * @return java.util.Collection of type activity.Activity.
     */
    public java.util.Collection<activity.Activity> getActivities() {
        return getActivityManager().getActivities();
    }

    /**
     * Returns all students registered in this course as a Collection of person.student.Student objects
     * @return java.util.Collection of type person.student.Student
     */
    public java.util.Collection<person.student.Student> getStudents() {
        return getStudentManager().getStudents();
    }

    /**
     * Returns a specific student registered to this course, given the student's universally unique identifier
     * @param studentUuid
     * @return
     */
    public person.student.Student getStudent(java.util.UUID studentUuid) {
        return getStudentManager().getStudent(studentUuid);
    }


    /**
     * Default getter for this.subject
     * @return
     */
    public String getSubject() { return this.subject; }

    /**
     * Default getter for this.uuid
     * @return java.util.UUID
     */
    public java.util.UUID getUuid() { return this.uuid; }

    /**
     * Default getter for this.id
     * @return
     */
    public int getID() { return this.id; }

    /**
     * Default getter for this.section
     * @return
     */
    public int getSection() { return this.section; }

    /**
     * Default getter for this.teacher
     * @return
     */
    public person.teacher.Teacher getTeacher() { return this.teacher; }

    /**
     * Override default toString and supply course information: subject, id, section, and teacher name
     * @return
     */
    public String toString() { return "Course:\n\tSubject: "+this.getSubject()+"\n\tID: "+this.getID()+"\n\tSection: "+this.getSection()+"\n\tTeacher: "+this.getTeacher().getFullName(); }
}
