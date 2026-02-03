package com.example.day3.service;

import com.example.day3.DTO.StudentRequestDto;
import com.example.day3.DTO.StudentResponseDto;
import com.example.day3.exception.StudentNotfoundException;
import com.example.day3.model.StudentModel;
import com.example.day3.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private  StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    //create
//    public StudentModel addStudent(StudentModel student){
//        return repository.save(student);
//    }
    public StudentResponseDto addStudent(StudentRequestDto dto){
        StudentModel student=new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());
        StudentModel saved=repository.save(student);
        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }

    // display
    public List<StudentResponseDto> getStudents(){
        return repository.findAll()
                .stream()
                .map(s->new StudentResponseDto(
                s.getId(),
                s.getName(),
                s.getAge(),
                s.getEmail()
        )).toList();
    }

    // update

    public StudentResponseDto updateStudent(String id, StudentRequestDto dto) {

        StudentModel student = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotfoundException("Student not found with id: " + id)
                );

        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel updated = repository.save(student);

        return new StudentResponseDto(
                updated.getId(),
                updated.getName(),
                updated.getAge(),
                updated.getEmail()
        );
    }

    // Delete
    public StudentResponseDto deleteStudent(String id) {
        StudentModel student = repository.findById(id)
                .orElseThrow(() -> new StudentNotfoundException("Student not found with id: " + id));
        StudentResponseDto responseDto = new StudentResponseDto(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getEmail()
        );
        repository.deleteById(id);
        return responseDto;
    }

}
