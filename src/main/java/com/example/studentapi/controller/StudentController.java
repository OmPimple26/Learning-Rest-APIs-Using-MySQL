package com.example.studentapi.controller;

import com.example.studentapi.dto.StudentDto;
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
    public StudentDto create(@RequestBody StudentDto dto) {
        return service.createStudent(dto);
    }

    @GetMapping
    public List<StudentDto> getAll() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentDto update(@PathVariable int id, @RequestBody StudentDto dto) {
        return service.updateStudent(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.deleteStudent(id);
        return "Deleted Successfully";
    }

    @GetMapping("/filter")
    public List<StudentDto> filter(@RequestParam(required = false) String department,
                                   @RequestParam(required = false) String year) {
        return service.filterStudents(department, year);
    }
}
