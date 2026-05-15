package _pro_backend.repository;

import _pro_backend.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

    boolean existsByEmail(String email);
}
