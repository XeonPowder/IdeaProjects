package person;

import manager.GradeManager;

public class Person {
    public enum PersonType {
        STUDENT,
        TEACHER
    }
    private java.util.UUID id;
    private PersonType personType;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String streetAddress;
    private String phoneNumber;
    private java.util.Date birthDate;
    private GradeManager gm;

    public Person(PersonType personType, String emailAddress, String firstName, String lastName, String streetAddress, String phoneNumber, java.util.Date birthDate) {
        this.id = java.util.UUID.randomUUID();
        this.personType = personType;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.gm = new GradeManager();
    }

    public Person(Person p) {
        this.id = p.id;
        this.personType = p.personType;
        this.emailAddress = p.emailAddress;
        this.firstName = p.firstName;
        this.lastName = p.lastName;
        this.streetAddress = p.streetAddress;
        this.phoneNumber = p.phoneNumber;
        this.birthDate = p.birthDate;
        this.gm = p.gm;
    }

    public GradeManager getGradeManager() {
        return this.gm;
    }

    public java.util.UUID getID() {
        return this.id;
    }

    public String getFullName() {
        return this.firstName+" "+this.lastName;
    }
}
