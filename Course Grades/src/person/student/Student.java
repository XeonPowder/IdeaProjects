package person.student;


public class Student extends person.Person {

    public Student(String emailAddress, String firstName, String lastName, String streetAddress, String phoneNumber, java.util.Date birthDate) {
        super(person.Person.PersonType.STUDENT, emailAddress,firstName,lastName,streetAddress,phoneNumber,birthDate);
    }
    public Student(person.Person p) {
        super(p);
    }
}
