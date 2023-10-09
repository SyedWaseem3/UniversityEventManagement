package com.geekster.UniversityEventManagement.controller;

import com.geekster.UniversityEventManagement.model.Department;
import com.geekster.UniversityEventManagement.model.Student;
import com.geekster.UniversityEventManagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class StudentController {
    @Autowired
    StudentService studentService;

    //Add Student
    @PostMapping("addStudent")
    public String addStudent(@RequestBody @Valid Student student){
        return studentService.addStudent(student);
    }

    //Add students
    @PostMapping("addStudents")
    public String addStudents(@RequestBody @Valid List<Student> students){
        return studentService.addStudents(students);
    }

    //Update Student
    @PutMapping("updateStudentById/id/{id}/department/{dept}")
    public String updateStudentById(@PathVariable Long id, @PathVariable Department dept){
        return studentService.updateStudentById(id, dept);
    }



    //Delete Student
    @DeleteMapping("deleteStudentById/{id}")
    public String deleteStudentById(@PathVariable Long id){
        return studentService.deleteStudentById(id);
    }

    //Get all students
    @GetMapping("getAllStudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    //Get Student by id
    @GetMapping("getStudentById/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
}
