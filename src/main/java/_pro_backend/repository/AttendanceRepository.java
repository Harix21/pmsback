package _pro_backend.repository;

import _pro_backend.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    List<Attendance> findBySessionId(int sessionId);

    boolean existsBySessionIdAndVhno(int sessionId, String vhno);
}