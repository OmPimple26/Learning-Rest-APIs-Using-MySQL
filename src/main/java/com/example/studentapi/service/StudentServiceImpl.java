package com.example.studentapi.service;

import com.example.studentapi.dto.StudentDto;
import com.example.studentapi.entity.Student;
import com.example.studentapi.repository.StudentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentServiceImpl implements StudentService{
    private final StudentRepository repo;

    @Override
    public Student createStudent(StudentDto dto) {
        Student s = new Student();
        s.setName(dto.getName());
        s.setEmail(dto.getEmail());
        s.setMobile(dto.getMobile());
        s.setDepartment(dto.getDepartment());
        s.setYear(dto.getYear());
        return repo.save(s);
    }

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student Not Found"));
    }

    @Override
    public Student updateStudent(int id, StudentDto dto) {
        Student s = getStudentById(id);
        s.setName(dto.getName());
        s.setEmail(dto.getEmail());
        s.setMobile(dto.getMobile());
        s.setDepartment(dto.getDepartment());
        s.setYear(dto.getYear());
        return repo.save(s);
    }

    @Override
    public void deleteStudent(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<Student> filterStudents(String department, String year) {

        if (department != null && year != null)
            return repo.findByDepartmentAndYear(department, year);

        else if (department != null)
            return repo.findByDepartment(department);

        else if (year != null)
            return repo.findByYear(year);

        return repo.findAll();
    }
}
