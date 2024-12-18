package com.example.StudentMng.service;

import com.example.StudentMng.model.Student;
import com.example.StudentMng.repo.SRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private SRepo studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> filterByGroup(String groupName) {
        return studentRepository.findByGroupName(groupName);
    }

    @Override
    public List<Student> filterByGrade(double grade) {
        return studentRepository.findByGradeGreaterThanEqual(grade);
    }
}
