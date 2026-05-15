package _pro_backend.service;

import java.util.List;

public interface AttendanceService {

    String mark(int sessionId, List<String> presentList);

    List<String> absentees(int sessionId);
}