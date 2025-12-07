package com.example.studentapi.service;

import com.example.studentapi.dto.StudentDto;
import com.example.studentapi.entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentDto dto);

    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student updateStudent(int id, StudentDto dto);

    void deleteStudent(int id);

    List<Student> filterStudents(String department, String year);
}
