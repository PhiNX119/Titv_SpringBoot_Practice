package com.xuanphi.hibernate;

import com.xuanphi.hibernate.dao.CourseRepository;
import com.xuanphi.hibernate.dao.TeacherDetailRepository;
import com.xuanphi.hibernate.dao.TeacherRepository;
import com.xuanphi.hibernate.entity.Course;
import com.xuanphi.hibernate.entity.Student;
import com.xuanphi.hibernate.entity.Teacher;
import com.xuanphi.hibernate.entity.TeacherDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class HibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(TeacherRepository teacherRepository, TeacherDetailRepository teacherDetailRepository, CourseRepository courseRepository) {
        return runner -> {
            createTeacher(teacherRepository);
            createCourse(teacherRepository, courseRepository);
        };
    }

    private void createTeacher(TeacherRepository teacherRepository) {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Xuan Phi");
        teacher.setLastName("Nguyen");
        teacher.setEmail("xuanphi2003@gmail.com");

        TeacherDetail teacherDetail = new TeacherDetail();
        teacherDetail.setGender(true);
        teacherDetail.setAddress("Hai Duong, Viet Nam");
        teacherDetail.setYoutubeChannel("CT-XP Official");

        teacher.setTeacherDetail(teacherDetail);

        Course course1 = new Course("SpringBoot Titv", "Learn about SpringBoot and Hibernate JPA.", null, null);
        Course course2 = new Course("JavaScript", "Learn about JS", null, null);

        teacher.addCourse(course1);
        teacher.addCourse(course2);


        System.out.println("Saving teacher..." + teacher);
        teacherRepository.save(teacher);
        System.out.println("Done.");
    }

    private void createCourse(TeacherRepository teacherRepository, CourseRepository courseRepository) {
        Teacher teacher = teacherRepository.findByIdJoinFetch(1);
        System.out.println("Teacher information:");
        System.out.println(teacher);

        //List<Course> courses = courseRepository.findByTeacherId(1);
        //teacher.setCourses(courses);

        Course course = new Course("C#.Net", "Learn about ASP.NET", null, null);

        //teacher.addCourse(course);
        //teacherRepository.saveAndFlush(teacher);

        Student student1 = new Student();
        student1.setFirstName("Thanh");
        student1.setLastName("Pham");
        Student student2 = new Student();
        student2.setFirstName("Duc");
        student2.setLastName("Pham");

        course.addStudent(student1);
        course.addStudent(student2);

        System.out.println("Saving course..." + course);
        courseRepository.save(course);
        System.out.println("Done.");

        System.out.println("List of course:");
        System.out.println(teacher.getCourses());
    }
}
