package _pro_backend.service;

import _pro_backend.entity.Attendance;
import _pro_backend.entity.Session;
import _pro_backend.entity.Student;
import _pro_backend.repository.AttendanceRepository;
import _pro_backend.repository.SessionRepository;
import _pro_backend.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepo;
    private final StudentRepository studentRepo;
    private final SessionRepository sessionRepo;

    @Override
    public String mark(int sessionId, List<String> presentList) {

        Session session = sessionRepo.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        if (!session.isActive()) {
            throw new RuntimeException("Session not active");
        }

        // Get students of batch
        List<Student> students = studentRepo.findAll()
                .stream()
                .filter(s -> s.getBatchId().equals(session.getBatchId()))
                .toList();

        int totalStudents = students.size();

        for (Student s : students) {

            boolean present = presentList.contains(s.getVhno());

            Attendance att = new Attendance();
            att.setSessionId(sessionId);
            att.setVhno(s.getVhno());
            att.setPresent(present);

            attendanceRepo.save(att);

            // ✅ Update percentage
            double old = s.getAttendance();

            if (present) {
                old += (100.0 / totalStudents);
            }

            s.setAttendance(old);
            studentRepo.save(s);
        }

        return "Attendance updated";
    }

    @Override
    public List<String> absentees(int sessionId) {

        return attendanceRepo.findBySessionId(sessionId)
                .stream()
                .filter(a -> !a.isPresent())
                .map(Attendance::getVhno)
                .toList();
    }
}