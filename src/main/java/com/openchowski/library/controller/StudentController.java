package com.openchowski.library.controller;

import com.openchowski.library.entity.Student;
import com.openchowski.library.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Student> findById(@PathVariable int id){
        return studentService.findById(id);
    }

    @PostMapping
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public Student save(@RequestBody Student newStudent, @PathVariable int id){
       return studentService.findById(id)
               .map(student -> {
                   student.setIndex(newStudent.getIndex());
                   student.setAge(newStudent.getAge());
                   student.setDateOfBirth(newStudent.getDateOfBirth());
                   student.setPerson(newStudent.getPerson());
                   return studentService.save(student);
               })
               .orElseGet(() -> {
                   newStudent.setId(id);
                   return studentService.save(newStudent);
               });
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        studentService.deleteById(id);
    }

}
