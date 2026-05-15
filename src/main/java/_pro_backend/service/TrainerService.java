package _pro_backend.service;

import _pro_backend.entity.Trainer;

import java.util.List;

public interface TrainerService {
    Trainer addTrainer(Trainer trainer);
    Trainer getTrainer(int id);
    List<Trainer> getAll();
    void deleteTrainer(int id);
    Trainer updateTrainer(int id, Trainer trainer);
}
