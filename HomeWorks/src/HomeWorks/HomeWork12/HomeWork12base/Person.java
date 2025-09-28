package HomeWorks.HomeWork12.HomeWork12base;

public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private long phone;
    private char gender;
    private int age;

    public Person(String lastName, String firstName, String middleName,
                  String birthDate, long phone, char gender, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName + " " +
                birthDate + " " + phone + " " + gender + " " + age;
    }

    public String getLastName() {
        return lastName;
    }
}