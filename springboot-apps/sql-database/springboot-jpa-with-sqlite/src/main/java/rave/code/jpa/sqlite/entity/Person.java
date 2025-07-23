package rave.code.jpa.sqlite.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name="id")
    private String id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email_id")
    private String emailId;
    @Column(name="age")
    private int age;
    @Column(name="created_date")
    private String createdDate;
    @Column(name="modified_date")
    private String modifiedDate;

    public Person(){
        this.id = UUID.randomUUID().toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Date toDate = new Date();
        this.createdDate = simpleDateFormat.format(toDate);
        this.modifiedDate = simpleDateFormat.format(toDate);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String toJsonString() {
        return String.format("{'id':'%s','firstName':'%s','lastName':'%s','emailId':'%s','age':%s,'createdDate':'%s','modifiedDate':'%s'}", this.id, this.firstName, this.lastName, this.emailId, this.age, this.createdDate, this.modifiedDate);
    }
}
