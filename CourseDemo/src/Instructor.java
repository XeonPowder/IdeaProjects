public class Instructor {
    private String name;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + name + '\'' +
                '}';
    }
}
