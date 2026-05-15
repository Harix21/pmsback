package _pro_backend.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface JobApplicationService {

    String applyJob(int jobId,
                    String vhno,
                    String email,
                    String phno,
                    String year,
                    MultipartFile resume) throws IOException;
}