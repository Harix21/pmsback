package _pro_backend.service;

import _pro_backend.entity.Trainer;
import _pro_backend.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainerServiceImpl implements TrainerService {

    private final TrainerRepository repo;

    @Override
    public Trainer addTrainer(Trainer trainer) {
        return repo.save(trainer);
    }
    @Override
    public Trainer getTrainer(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));
    }
    @Override
    public List<Trainer> getAll() {
        return repo.findAll();
    }

    @Override
    public void deleteTrainer(int id) {

        Trainer trainer = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));

        repo.delete(trainer);
    }
    @Override
    public Trainer updateTrainer(int id, Trainer trainer) {

        Trainer existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));

        existing.setName(trainer.getName());
        existing.setEmail(trainer.getEmail());
        existing.setPhno(trainer.getPhno());
        existing.setExpertise(trainer.getExpertise());

        return repo.save(existing);
    }
}