package _pro_backend.controller;

import java.util.List;

import _pro_backend.dto.StudentDto;
import _pro_backend.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")


public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // CREATE
    @PostMapping
    public StudentDto createStudent(@RequestBody StudentDto dto) {
        return studentService.createStudent(dto);
    }

    // GET ALL
    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    // GET BY VHNO
    @GetMapping("/{vhno}")
    public StudentDto getStudentById(@PathVariable String vhno) {
        return studentService.getStudentById(vhno);
    }

    // UPDATE
    @PutMapping("/{vhno}")
    public StudentDto updateStudent(@PathVariable String vhno,
                                    @RequestBody StudentDto dto) {
        return studentService.updateStudent(vhno, dto);
    }

    // DELETE
    @DeleteMapping("/{vhno}")
    public String deleteStudent(@PathVariable String vhno) {
        studentService.deleteStudent(vhno);
        return "Student Deleted Successfully";
    }
}