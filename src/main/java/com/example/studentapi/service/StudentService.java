package com.example.studentapi.service;

import com.example.studentapi.dto.StudentDto;
// import com.example.studentapi.entity.Student;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto dto);

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(int id);

    StudentDto updateStudent(int id, StudentDto dto);

    void deleteStudent(int id);

    List<StudentDto> filterStudents(String department, String year);
}
