package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDAO;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class WebController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

//    @Autowired
//    OAuth2AccessToken accessToken;
    @Autowired
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "pages/home";
    }

    @RequestMapping(value = "/secure-portal/students", method = RequestMethod.GET)
    public @ResponseBody Iterable<Student> getStudents() {
//    	log.info("getStudents: Retreiving students from db by user : {}",accessToken.getTokenValue());
        Iterable<Student> students = studentDAO.findAll();
           return students;
    }


    @RequestMapping(value = "/secure-portal/students/{id}", method = RequestMethod.GET)
    public @ResponseBody Student getStudentById(@PathVariable("id") long id) {
//    	log.info("getStudentById: Retreiving student with id {} from db by user : {} ",id,accessToken.getTokenValue());
    	Optional<Student> student = studentDAO.findById(id);
        return student.get();
    }
}
