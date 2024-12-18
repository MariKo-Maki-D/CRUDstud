package com.example.StudentMng.repo;

import com.example.StudentMng.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SRepo extends JpaRepository<Student, Long> {
    List<Student> findByGroupName(String groupName);
    List<Student> findByGradeGreaterThanEqual(double grade);
}
