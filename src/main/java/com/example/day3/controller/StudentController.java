package com.example.day3.controller;

import com.example.day3.model.StudentModel;
import com.example.day3.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    private  final StudentService service;
    public StudentController(StudentService service){
        this.service=service;
    }
    // create function api
    @PostMapping("/add-student")
    public StudentModel addStudent(@RequestBody StudentModel student){
        return service.addStudent(student);
    }
}
