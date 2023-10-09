package com.geekster.UniversityEventManagement.service;

import com.geekster.UniversityEventManagement.model.Department;
import com.geekster.UniversityEventManagement.model.Student;
import com.geekster.UniversityEventManagement.repo.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    IStudentRepo studentRepo;

    public String addStudent(Student student) {
        studentRepo.save(student);
        return student.getStudentFirstName() + " added!";
    }

    public String addStudents(List<Student> students) {
        studentRepo.saveAll(students);
        return students.size() + " students were added!";
    }

    public String updateStudentById(Long id, Department dept) {
        Student student = studentRepo.findById(id).orElse(null);
        if(student != null){
            student.setStudentDepartment(dept);
            studentRepo.save(student);
            return student.getStudentFirstName() + "'s department changed!";
        }
        return "Student not found by the id given.";
    }

    public String deleteStudentById(Long id) {
        studentRepo.deleteById(id);
        return id + " student deleted!";
    }

    public List<Student> getAllStudents() {
        return (List<Student>) studentRepo.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepo.findById(id).get();
    }

}
