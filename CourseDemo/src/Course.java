public class Course{
    private Instructor one;
    private Book required;
    public Course(String instructorName, String bookTitle) {
        required = new Book();
        required.setTitle(bookTitle);
        one = new Instructor();
        one.setName(instructorName);
    }
    public Book getBook() {
        return this.required;
    }
    public Instructor getInstructor() {
        return this.one;
    }

    @Override
    public String toString() {
        return "This course is taught by, "+getInstructor().getName()+", and requires the book titled: "+getBook().getTitle()+".";
    }
}

