package com.xuanphi.managestudent2.service;

import com.xuanphi.managestudent2.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();

    public Student getStudentById(int id);

    public Student addStudent(Student student);

    public Student updateStudent(Student student);

    public void deleteStudentById(int id);

    public List<Student> getAllStudentNotFirstName(String name);
}
