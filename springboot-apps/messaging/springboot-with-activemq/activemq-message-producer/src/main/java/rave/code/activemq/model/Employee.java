package rave.code.activemq.model;

import java.util.Date;

public class Employee {

    private String firstName;
    private String lastName;
    private long id;
    private Date date;
    private int age;

    public Employee(){}

    public Employee(String firstName, String lastName, long id, Date date, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.date = date;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
