package _pro_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "students")

public class Student {

    @Id
    @Column(name = "vhno")
    private String vhno;   // ✅ PRIMARY KEY

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "phno")
    private String phno;

    private String year;

    @Column(name = "batch_id")
    private String batchId;

    private double attendance;

    @Column(name = "placement_status")
    private String placementStatus;

    private LocalDate dob;

    private String gender;

    private String password;
}