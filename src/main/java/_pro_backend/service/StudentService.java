package _pro_backend.service;

import _pro_backend.dto.StudentDto;

import java.util.List;


public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(String vhno);

    StudentDto updateStudent(String vhno, StudentDto studentDto);

    void deleteStudent(String vhno);
}