package com.xuanphi.hibernate.dao;

import com.xuanphi.hibernate.entity.TeacherDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDetailRepository extends JpaRepository<TeacherDetail, Integer> {
}
