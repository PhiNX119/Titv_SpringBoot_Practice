package com.xuanphi.managestudent2.dao;

import com.xuanphi.managestudent2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path = "students")
public interface StudentRepository extends JpaRepository<Student, Integer> {
    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    //public List<Student> findByFirstNameNot(String firstName);

    @Query(" SELECT s FROM Student s WHERE s.firstName <> ?1 ")
    public List<Student> findByFirstNameNot(String firstName);
}
