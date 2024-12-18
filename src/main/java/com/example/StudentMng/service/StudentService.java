package com.example.StudentMng.service;
import com.example.StudentMng.model.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    List<Student> filterByGroup(String groupName);
    List<Student> filterByGrade(double grade);
}
