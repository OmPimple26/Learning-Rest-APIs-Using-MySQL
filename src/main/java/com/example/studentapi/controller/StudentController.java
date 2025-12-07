package com.example.studentapi.controller;

import com.example.studentapi.dto.StudentDto;
import com.example.studentapi.entity.Student;
import com.example.studentapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")

public class StudentController {
    private final StudentService service;

    @PostMapping
    public Student create(@RequestBody StudentDto dto) {
        return service.createStudent(dto);
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable int id, @RequestBody StudentDto dto) {
        return service.updateStudent(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.deleteStudent(id);
        return "Deleted Successfully";
    }

    @GetMapping("/filter")
    public List<Student> filter(@RequestParam(required = false) String department,
                                @RequestParam(required = false) String year) {
        return service.filterStudents(department, year);
    }
}
