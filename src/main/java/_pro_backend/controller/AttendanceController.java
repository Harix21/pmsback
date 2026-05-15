package _pro_backend.controller;

import _pro_backend.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AttendanceController {

    private final AttendanceService service;

    @PostMapping("/{sessionId}")
    public String mark(
            @PathVariable int sessionId,
            @RequestBody List<String> presentList
    ) {
        return service.mark(sessionId, presentList);
    }

    @GetMapping("/absentees/{sessionId}")
    public List<String> absentees(@PathVariable int sessionId) {
        return service.absentees(sessionId);
    }
}