package com.openchowski.library.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "borrow")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date_of_borrow")
    private Date dateOfBorrow;

    @Column(name = "date_of_return")
    private Date dateOfReturn;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "student_id")
    private int studentId;

    public Borrow() {
    }

    public Borrow(Date dateOfBorrow, Date dateOfReturn, int employeeId, int studentId) {
        this.dateOfBorrow = dateOfBorrow;
        this.dateOfReturn = dateOfReturn;
        this.employeeId = employeeId;
        this.studentId = studentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfBorrow() {
        return dateOfBorrow;
    }

    public void setDateOfBorrow(Date dateOfBorrow) {
        this.dateOfBorrow = dateOfBorrow;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", dateOfBorrow=" + dateOfBorrow +
                ", dateOfReturn=" + dateOfReturn +
                ", employeeId=" + employeeId +
                ", studentId=" + studentId +
                '}';
    }
}
