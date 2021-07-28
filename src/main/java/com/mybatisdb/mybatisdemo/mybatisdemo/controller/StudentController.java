package com.mybatisdb.mybatisdemo.mybatisdemo.controller;

import com.mybatisdb.mybatisdemo.mybatisdemo.entity.Student;
import com.mybatisdb.mybatisdemo.mybatisdemo.repository.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @GetMapping
    List<Student> getAllStudents() {
        return studentMapper.getAllStudents();
    }

    @GetMapping("/{rollNo}")
    Student getStudent(@PathVariable String rollNo) {
        return studentMapper.getStudentByRollNo(rollNo);
    }

    @DeleteMapping("/{rollNo}")
    String deleteStudent(@PathVariable String rollNo) {
        studentMapper.deleteStudent(rollNo);
        return "Record deleted";
    }

    @PostMapping
    Student saveStudent(@RequestBody  Student student){
        System.out.println(student);
        studentMapper.saveStudent(student);
        return student;
    }

    @PutMapping
    Student updateStudent(@RequestBody  Student student){
        System.out.println(student);
        studentMapper.updateStudent(student);
        return student;
    }
}
