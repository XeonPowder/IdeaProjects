package manager;

import person.student.Student;

public class StudentManager {
    private java.util.HashMap<java.util.UUID, Student> registry = new java.util.HashMap<>(0);

    public Student registerStudent(Student s) {
        registry.put(s.getID(), s);
        return getStudent(s.getID());
    }

    public Student getStudent(java.util.UUID uuid) {
        return registry.get(uuid);
    }

    public java.util.Collection<Student> getStudents() {
        return registry.values();
    }
}
