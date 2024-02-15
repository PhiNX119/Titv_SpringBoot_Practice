package com.xuanphi.mvc.dao;

import com.xuanphi.mvc.entity.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> findAll();

    public Student getById(int id);

    public Student save(Student student);

    public Student saveAndFLush(Student student);

    public void deleteById(int id);


}
