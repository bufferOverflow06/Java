package com.example.studentapp.repo;

import com.example.studentapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer>
{
    @Query("SELECT s FROM Student s WHERE s.marks = (SELECT MAX(s2.marks) FROM Student s2)")
    Student findStudentWithMaxMarks();
}
