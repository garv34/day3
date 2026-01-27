package com.example.day3.controller;

import com.example.day3.model.StudentModel;
import com.example.day3.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    // display
    @GetMapping("/students")
    public List<StudentModel> getStudents(){
        return service.getStudents();
    }
    @PutMapping("/update/{id}")
    public StudentModel updateStudent(@PathVariable String id,@RequestBody StudentModel student){
        return service.updateStudent(id,student);
    }
    @DeleteMapping("/delete/{id}")
    public StudentModel deleteStudent(@PathVariable String id){
        return service.deleteStudent(id);
    }
}
