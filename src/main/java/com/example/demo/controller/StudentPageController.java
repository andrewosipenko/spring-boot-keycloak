package com.example.demo.controller;

import com.example.demo.WebConstants;
import com.example.demo.model.Student;
import com.example.demo.model.StudentDAO;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(WebConstants.URLs.SECURE_PORTAL + "/students")
public class StudentPageController {
    @Resource
    private StudentDAO studentDAO;

    @PostConstruct
    // add students for demonstration
    public void addStudents() {

        Student student1 = new Student();
        student1.setId(101);
        student1.setAddress("Texas");
        student1.setName("Alice");
        student1.setGrade("B");
        studentDAO.save(student1);

        Student student2 = new Student();
        student2.setId(102);
        student2.setAddress("NY");
        student2.setName("Rohan");
        student2.setGrade("A");
        studentDAO.save(student2);
    }

    @GetMapping
    public @ResponseBody Iterable<Student> getStudents() {
        Iterable<Student> students = studentDAO.findAll();
        return students;
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody Student getStudentById(@PathVariable("id") long id) {
        Optional<Student> student = studentDAO.findById(id);
        return student.get();
    }
}
