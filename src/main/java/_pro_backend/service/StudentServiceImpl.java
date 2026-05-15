package _pro_backend.service;

import java.util.List;
import java.util.stream.Collectors;

import _pro_backend.dto.StudentDto;
import _pro_backend.entity.Student;
import _pro_backend.mapper.StudentMapper;
import _pro_backend.repository.StudentRepository;
import _pro_backend.service.StudentService;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    @Override
    public StudentDto createStudent(StudentDto dto) {

        // prevent duplicate vhno
        if (studentRepository.existsById(dto.getVhno())) {
            throw new RuntimeException("VHNO already exists");
        }

        Student student = StudentMapper.mapToStudent(dto);
        Student saved = studentRepository.save(student);

        return StudentMapper.mapToStudentDto(saved);
    }

    // GET ALL
    @Override
    public List<StudentDto> getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .map(StudentMapper::mapToStudentDto)
                .collect(Collectors.toList());
    }

    // GET BY VHNO
    @Override
    public StudentDto getStudentById(String vhno) {

        Student student = studentRepository.findById(vhno)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return StudentMapper.mapToStudentDto(student);
    }

    // UPDATE
    @Override
    public StudentDto updateStudent(String vhno, StudentDto dto) {

        Student student = studentRepository.findById(vhno)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setPhno(dto.getPhno());
        student.setYear(dto.getYear());
        student.setBatchId(dto.getBatchId());
        student.setAttendance(dto.getAttendance());
        student.setPlacementStatus(dto.getPlacementStatus());
        student.setDob(dto.getDob());
        student.setGender(dto.getGender());
        student.setPassword(dto.getPassword());

        Student updated = studentRepository.save(student);

        return StudentMapper.mapToStudentDto(updated);
    }

    // DELETE
    @Override
    public void deleteStudent(String vhno) {

        if (!studentRepository.existsById(vhno)) {
            throw new RuntimeException("Student not found");
        }

        studentRepository.deleteById(vhno);
    }
}