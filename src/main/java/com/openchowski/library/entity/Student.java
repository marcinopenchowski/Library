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

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Student() {
    }

    public Student(int index, Date dateOfBirth, int age, Person person) {
        this.index = index;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.person = person;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", index=" + index +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                ", person=" + person +
                '}';
    }
}
