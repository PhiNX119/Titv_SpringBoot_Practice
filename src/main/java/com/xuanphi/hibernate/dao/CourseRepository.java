package com.xuanphi.hibernate.dao;

import com.xuanphi.hibernate.entity.Course;
import com.xuanphi.hibernate.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query(" SELECT c FROM Course c WHERE c.teacher.id = ?1 ")
    public List<Course> findByTeacherId(int id);
}
