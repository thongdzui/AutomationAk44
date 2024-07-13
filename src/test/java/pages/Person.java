package pages;

import java.util.List;

//POJO
public class Person {
    private String lastName;
    private String firstName;
    private String due;

    public Person(String rowContent) {
        String[] cells = rowContent.split(" ");
        this.firstName = cells[0];
        this.lastName = cells[1];
        this.due = cells[3];
    }

    public double getDue() {
        return Double.parseDouble(due.replace("$",""));
    }

    public String getFullName(){
        return String.format("%s %s", firstName, lastName);
    }


}
