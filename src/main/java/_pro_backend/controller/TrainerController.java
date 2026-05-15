package _pro_backend.controller;

import _pro_backend.entity.Trainer;
import _pro_backend.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainers")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TrainerController {

    private final TrainerService service;

    @PostMapping
    public Trainer add(@RequestBody Trainer t) {
        return service.addTrainer(t);
    }
    @GetMapping("/{id}")
    public Trainer get(@PathVariable int id) {
        return service.getTrainer(id);
    }



    @GetMapping
    public List<Trainer> all() {
        return service.getAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.deleteTrainer(id);
        return ResponseEntity.ok("Trainer deleted successfully");
    }
    @PutMapping("/{id}")
    public Trainer update(@PathVariable int id, @RequestBody Trainer trainer) {
        return service.updateTrainer(id, trainer);
    }
}