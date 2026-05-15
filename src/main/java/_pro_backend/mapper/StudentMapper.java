package _pro_backend.mapper;

import _pro_backend.dto.StudentDto;
import _pro_backend.entity.Student;



public class StudentMapper {

    public static StudentDto mapToStudentDto(Student s) {
        return new StudentDto(
                s.getVhno(),
                s.getName(),
                s.getEmail(),
                s.getPhno(),
                s.getYear(),
                s.getBatchId(),
                s.getAttendance(),
                s.getPlacementStatus(),
                s.getDob(),
                s.getGender(),
                s.getPassword()
        );
    }

    public static Student mapToStudent(StudentDto d) {
        return new Student(
                d.getVhno(),
                d.getName(),
                d.getEmail(),
                d.getPhno(),
                d.getYear(),
                d.getBatchId(),
                d.getAttendance(),
                d.getPlacementStatus(),
                d.getDob(),
                d.getGender(),
                d.getPassword()
        );
    }
}