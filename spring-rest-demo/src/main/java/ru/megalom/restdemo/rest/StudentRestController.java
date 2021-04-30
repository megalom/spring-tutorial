package ru.megalom.restdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.megalom.restdemo.entity.Student;
import ru.megalom.restdemo.entity.StudentErrorResponce;
import ru.megalom.restdemo.exception.StudentNotFoundException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> students=new ArrayList<>();

    public StudentRestController(){
        students.add(new Student("Ivan","Urgant"));
        students.add(new Student("Pavel","Volya"));
        students.add(new Student("Jason","Statham"));
        students.add(new Student("Katy","Perry"));
    }

    @GetMapping("/students")
    public List<Student> getSutdents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if((studentId>=students.size())||(studentId<0)){
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }
        return students.get(studentId);
    }


}
