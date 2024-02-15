package com.xuanphi.api.rest;

import com.xuanphi.api.entity.Student;
import com.xuanphi.api.exception.StudentException;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    public List<Student> studentList;

    @PostConstruct
    public void createStudentList() {
        studentList = new ArrayList<Student>();
        studentList.add(new Student(1, "John Doe", 20, "Mathematics", 85.5));
        studentList.add(new Student(2, "Jane Smith", 21, "Physics", 92.0));
        studentList.add(new Student(3, "Bob Johnson", 19, "Chemistry", 78.5));
        studentList.add(new Student(4, "Alice Williams", 22, "Computer Science", 89.7));
        studentList.add(new Student(5, "David Brown", 20, "Biology", 75.2));
    }

    @GetMapping("/")
    public List<Student> getStudentList() {
        return studentList;
    }

    @GetMapping("/{id}")
    public Student getStudent1(@PathVariable int id) {
        Student result = null;
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        if (result == null) {
            throw new StudentException("Have no student with id: " + id);
        }
        return result;
    }

    @GetMapping("/index/{index}")
    public Student getStudent2(@PathVariable int index) {
        Student result = null;
        try {
            result = studentList.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new StudentException("Have no student with index: " + index);
        }
        return result;
    }
}
