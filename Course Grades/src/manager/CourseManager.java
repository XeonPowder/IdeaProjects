package manager;

public class CourseManager {
    private java.util.HashMap<java.util.UUID, course.Course> registry = new java.util.HashMap<>(0);

    public course.Course registerCourse(course.Course c) {
        registry.put(c.getUuid(), c);
        return getCourse(c.getUuid());
    }

    public course.Course getCourse(java.util.UUID uuid) {
        return registry.get(uuid);
    }

    public java.util.Collection<course.Course> getCourses() {
        return registry.values();
    }

}
