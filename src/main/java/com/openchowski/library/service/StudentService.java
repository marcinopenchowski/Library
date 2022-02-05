package com.openchowski.library.service;

import com.openchowski.library.dao.StudentRepo;
import com.openchowski.library.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    public Optional<Student> findById(int id) {
        return studentRepo.findById(id);
    }
}
