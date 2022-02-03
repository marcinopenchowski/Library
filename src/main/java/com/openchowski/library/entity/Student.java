package com.openchowski.library.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "index")
    private int index;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "age")
    private int age;

    @Column(name = "person_id")
    private int personId;

    public Student() {
    }

    public Student(int index, Date dateOfBirth, int age, int personId) {
        this.index = index;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.personId = personId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", index=" + index +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                ", personId=" + personId +
                '}';
    }
}
