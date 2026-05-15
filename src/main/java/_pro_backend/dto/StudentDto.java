package _pro_backend.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StudentDto {

    private String vhno;
    private String name;
    private String email;
    private String phno;
    private String year;
    private String batchId;
    private double attendance;
    private String placementStatus;
    private LocalDate dob;
    private String gender;
    private String password;
}