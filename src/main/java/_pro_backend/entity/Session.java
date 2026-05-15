package _pro_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "sessions")
@Getter
@Setter
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String sessionName;

    private LocalDate date;

    private LocalTime startTime;
    private LocalTime endTime;

    private String batchId;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
}