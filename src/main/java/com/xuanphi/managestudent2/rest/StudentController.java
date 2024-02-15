package com.xuanphi.managestudent2.rest;

import com.xuanphi.managestudent2.dao.StudentDAO;
import com.xuanphi.managestudent2.entity.Student;
import com.xuanphi.managestudent2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    @GetMapping
//    public List<Student> getAllStudents() {
//        return this.studentService.getAllStudents();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
//        Student student = studentService.getStudentById(id);
//        if (student != null) {
//            return ResponseEntity.ok(student);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
//        student.setId(0);
//        student = studentService.addStudent(student);
//        return ResponseEntity.status(HttpStatus.CREATED).body(student);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
//        Student existingStudent = studentService.getStudentById(id);
//        if (existingStudent != null) {
//            existingStudent.setFirstName(student.getFirstName());
//            existingStudent.setLastName(student.getLastName());
//            existingStudent.setEmail(student.getEmail());
//            studentService.updateStudent(existingStudent);
//            return ResponseEntity.ok(existingStudent);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
//        Student existingStudent = studentService.getStudentById(id);
//        if (existingStudent != null) {
//            studentService.deleteStudentById(id);
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping("/not-first-name/{name}")
    public List<Student> getAllStudentNotFirstName(@PathVariable String name){
        return studentService.getAllStudentNotFirstName(name);
    }
}