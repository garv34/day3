package com.example.day3.controller;

import com.example.day3.DTO.StudentRequestDto;
import com.example.day3.DTO.StudentResponseDto;
import com.example.day3.model.StudentModel;
import com.example.day3.service.StudentService;
import jakarta.validation.Valid;
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
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto student){
        return service.addStudent(student);
    }
    // display
    @GetMapping("/students")
    public List<StudentResponseDto> getStudents(){
        return service.getStudents();
    }
    @PutMapping("/update/{id}")
    public StudentResponseDto updateStudent(@PathVariable String id,@RequestBody StudentRequestDto student){
        return service.updateStudent(id,student);
    }
    @DeleteMapping("/delete/{id}")
    public StudentResponseDto deleteStudent(@PathVariable String id){
        return service.deleteStudent(id);
    }
}
