package com.example.studentapp.service;

import com.example.studentapp.model.Student;
import com.example.studentapp.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepo;

    public Student saveStudent(Student student){
        return studentRepo.save(student);
    }

    public List<Student> getAllStudent(){
        return studentRepo.findAll();
    }

    public Student getById(int roll){
        return studentRepo.findById(roll).orElse(null);
    }

    public void deleteById(int roll){
        studentRepo.deleteById(roll);
    }

    public Student getTopper() {
        return studentRepo.findStudentWithMaxMarks();
    }
}
