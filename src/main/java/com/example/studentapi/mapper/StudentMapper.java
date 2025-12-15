package com.example.studentapi.mapper;

import com.example.studentapi.dto.StudentDto;
import com.example.studentapi.entity.Student;

public class StudentMapper {

    // Entity → DTO
    public static StudentDto toDto(Student student) {
        if (student == null) return null;

        StudentDto dto = new StudentDto();
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setMobile(student.getMobile());
        dto.setDepartment(student.getDepartment());
        dto.setYear(student.getYear());
        return dto;
    }

    // DTO → Entity
    public static Student toEntity(StudentDto dto) {
        if (dto == null) return null;

        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setMobile(dto.getMobile());
        student.setDepartment(dto.getDepartment());
        student.setYear(dto.getYear());
        return student;
    }
}