package person.teacher;

public class Teacher extends person.Person {
    public Teacher(String emailAddress, String firstName, String lastName,  String streetAddress, String phoneNumber, java.util.Date birthDate) {
        super(person.Person.PersonType.TEACHER,emailAddress,firstName,lastName,streetAddress,phoneNumber,birthDate);
    }
    public Teacher(person.Person p) {
        super(p);
    }
}
