package com.openchowski.library.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "seniority")
    private int seniority;

    @Column(name = "date_of_birth")
    private int dateOfBirth;

    @Column(name = "age")
    private int age;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Employee() {
    }


    public Employee(int seniority, int dateOfBirth, int age, Person person) {
        this.seniority = seniority;
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

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
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
        return "Employee{" +
                "id=" + id +
                ", seniority=" + seniority +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                ", person=" + person +
                '}';
    }
}
