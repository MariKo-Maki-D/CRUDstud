package com.example.StudentMng.controller;

import com.example.StudentMng.model.Student;
import com.example.StudentMng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "list";
    }


    @GetMapping("/create")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
        student.setId(id);
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/filter")
    public String filterStudents(@RequestParam String groupName, @RequestParam double grade, Model model) {
        if (!groupName.isEmpty()) {
            model.addAttribute("students", studentService.filterByGroup(groupName));
        } else {
            model.addAttribute("students", studentService.filterByGrade(grade));
        }
        return "list";
    }

}
