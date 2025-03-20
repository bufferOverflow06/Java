package com.example.SpringJDBCx.service;

import com.example.SpringJDBCx.model.Student;
import com.example.SpringJDBCx.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo repo;

    public void addStudent(Student s) {
        repo.save(s);
    }

    public StudentRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public List<Student> getStudents() {
        return repo.findAll();
    }
}
