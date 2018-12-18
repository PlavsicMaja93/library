package com.springboot2restservicebasic.student.controller;

import com.springboot2restservicebasic.student.model.Student;
import com.springboot2restservicebasic.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> retrieveAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student retrieveStudent(@PathVariable long id) {
        Optional<Student> student = studentRepository.findById(id);

        return student.get();
    }

    @PostMapping("/students/promeni")
    public Student promeni(@RequestBody Student st) {
        Optional<Student> student = studentRepository.findById(st.getIndexId());  // student je objekat klase Optional

        student.get().setName(st.getName());  // student.get() je objekat klase Student
        student.get().setProgram(st.getProgram());
        studentRepository.save(student.get());
        return student.get();
    }

    @PostMapping ("/students/dodaj")
    public Map dodaj (@RequestBody Student st) {
        studentRepository.save(st);
        Map response = new HashMap();
        response.put("success", true);
        return response;
    }
}

