package com.example.studentapi.service;

import com.example.studentapi.dto.StudentDto;
import com.example.studentapi.entity.Student;
import com.example.studentapi.mapper.StudentMapper;
import com.example.studentapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;

    @Override
    public StudentDto createStudent(StudentDto dto) {
        Student student = StudentMapper.toEntity(dto);
        Student saved = repo.save(student);
        return StudentMapper.toDto(saved);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return repo.findAll()
                .stream()
                .map(StudentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentById(int id) {
        Student student = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student Not Found"));
        return StudentMapper.toDto(student);
    }

    @Override
    public StudentDto updateStudent(int id, StudentDto dto) {
        Student student = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student Not Found"));

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setMobile(dto.getMobile());
        student.setDepartment(dto.getDepartment());
        student.setYear(dto.getYear());

        Student updated = repo.save(student);
        return StudentMapper.toDto(updated);
    }

    @Override
    public void deleteStudent(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<StudentDto> filterStudents(String department, String year) {

        List<Student> students;

        if (department != null && year != null)
            students = repo.findByDepartmentAndYear(department, year);
        else if (department != null)
            students = repo.findByDepartment(department);
        else if (year != null)
            students = repo.findByYear(year);
        else
            students = repo.findAll();

        return students.stream()
                .map(StudentMapper::toDto)
                .collect(Collectors.toList());
    }
}
