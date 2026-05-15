package _pro_backend.service;

import _pro_backend.entity.Job;
import _pro_backend.entity.JobApplication;
import _pro_backend.entity.Student;
import _pro_backend.repository.JobApplicationRepository;
import _pro_backend.repository.JobRepository;
import _pro_backend.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class JobApplicationServiceImpl implements JobApplicationService {

    private final StudentRepository studentRepo;
    private final JobRepository jobRepo;
    private final JobApplicationRepository appRepo;

    @Override
    public String applyJob(int jobId,
                           String vhno,
                           String email,
                           String phno,
                           String year,
                           MultipartFile resume) throws IOException {

        // 🔴 Check Job exists
        Job job = jobRepo.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        // 🔴 Check Student exists
        Student student = studentRepo.findById(vhno)
                .orElseThrow(() -> new RuntimeException("VHNO not found"));

        // 🔴 Email validation
        if (!student.getEmail().equals(email)) {
            throw new RuntimeException("Email does not match student record");
        }

        // 🔴 Phone validation
        if (!student.getPhno().equals(phno)) {
            throw new RuntimeException("Phone number does not match");
        }


        // 🔴 Prevent duplicate application
        boolean alreadyApplied = appRepo
                .findAll()
                .stream()
                .anyMatch(a -> a.getJobId() == jobId && a.getVhno().equals(vhno));

        if (alreadyApplied) {
            throw new RuntimeException("Already applied for this job");
        }

        // 🔴 Validate PDF
        if (!resume.getOriginalFilename().endsWith(".pdf")) {
            throw new RuntimeException("Only PDF allowed");
        }

        // 🔴 Save file
        String extension = resume.getOriginalFilename()
                .substring(resume.getOriginalFilename().lastIndexOf("."));

        String fileName = vhno + "_" + jobId + extension;

        String path = "uploads/" + fileName;

        Files.write(Paths.get(path), resume.getBytes());

        // 🔴 Save application
        JobApplication app = new JobApplication();
        app.setJobId(jobId);
        app.setVhno(vhno);
        app.setEmail(email);
        app.setPhno(phno);
        app.setYear(year);
        app.setResumePath(path);

        appRepo.save(app);

        return "Application Submitted Successfully";
    }
}