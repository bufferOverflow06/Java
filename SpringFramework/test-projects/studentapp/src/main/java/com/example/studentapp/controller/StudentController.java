package com.example.studentapp.controller;

import com.example.studentapp.model.Student;
import com.example.studentapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();
    }

    @GetMapping("/topper")
    public ResponseEntity<?> getTopper(){
        Student topper = studentService.getTopper();
        if(topper == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No students available.");
        }
        return ResponseEntity.ok(topper);
    }

    @GetMapping("/{roll}")
    public ResponseEntity<?> getStudent(@PathVariable int roll){
        Student s = studentService.getById(roll);
        if(s == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
        return ResponseEntity.ok(s);
    }

    @DeleteMapping("/{roll}")
    public String deleteStudent(@PathVariable int roll){
        Student s = studentService.getById(roll);
        if(s == null){
            return "Student not found";
        }
        studentService.deleteById(roll);
        return s.getName() + ":" + s.getMarks() + "was deleted";
    }
}
