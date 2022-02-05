package com.openchowski.library.controller;

import com.openchowski.library.entity.Student;
import com.openchowski.library.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;


    public String findAll(Model model){

        List<Student> studentList = studentService.findAll();

        model.addAttribute("studentList", studentList);
        return "";
    }

}
