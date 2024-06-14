package herokuapp;
//POJO
public class Person {
    String lastName;
    String firstName;
    Double due;

    public Person(String lastName, Double due, String firstName) {
        this.lastName = lastName;
        this.due = due;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Double getDue() {
        return due;
    }
}
