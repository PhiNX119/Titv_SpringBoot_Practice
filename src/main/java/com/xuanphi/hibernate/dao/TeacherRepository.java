package com.xuanphi.hibernate.dao;

import com.xuanphi.hibernate.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query(" SELECT t FROM Teacher t WHERE t.id = ?1 ")
    public Teacher findById(int id);

    @Query(" SELECT t FROM Teacher t JOIN FETCH t.courses JOIN FETCH t.teacherDetail WHERE t.id = ?1 ")
    public Teacher findByIdJoinFetch(int id);
}
