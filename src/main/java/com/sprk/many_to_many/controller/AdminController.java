package com.sprk.many_to_many.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprk.many_to_many.dto.StudentWithCourseDto;
import com.sprk.many_to_many.entity.Course;
import com.sprk.many_to_many.entity.Student;
import com.sprk.many_to_many.mapper.StudentMapper;
import com.sprk.many_to_many.repository.CourseRepository;
import com.sprk.many_to_many.repository.StudentRepository;
import com.sprk.many_to_many.service.AdminService;
import com.sprk.many_to_many.service.CourseService;
import com.sprk.many_to_many.service.StudentService;

@RestController
public class AdminController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private AdminService adminService;

    @PostMapping("/assign-course-to-student")
    public String addCourseToStudent(@RequestParam int rollNo, @RequestParam int courseId){
        return adminService.addCourseToStudent(rollNo, courseId);
    }

    @GetMapping("/get-student-with-course/{rollNo}")
    public StudentWithCourseDto getStudentWithCourses(@PathVariable int rollNo){
        return adminService.getStudentWithCourses(rollNo);
    }

    /* 
    @GetMapping("/get-student-with-course/{rollNo}")
    public StudentWithCourseDto getStudentWithCourses(@PathVariable int rollNo){
        Student student = studentRepository.findStudentWithCourses(rollNo).orElseThrow(() -> new RuntimeException("Student not found"));
        StudentWithCourseDto studentWithCourseDto = StudentMapper.mappedStudentToStudentWithCourseDto(student, new StudentWithCourseDto());

        return studentWithCourseDto;
    }*/
}
