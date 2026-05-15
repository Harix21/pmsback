package _pro_backend.controller;

import _pro_backend.service.JobApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/apply")
@CrossOrigin("*")
@RequiredArgsConstructor
public class JobApplicationController {

    private final JobApplicationService service;

    @PostMapping
    public String applyJob(
            @RequestParam int jobId,
            @RequestParam String vhno,
            @RequestParam String email,
            @RequestParam String phno,
            @RequestParam String year,
            @RequestParam MultipartFile resume
    ) throws IOException {

        return service.applyJob(jobId, vhno, email, phno, year, resume);
    }
}