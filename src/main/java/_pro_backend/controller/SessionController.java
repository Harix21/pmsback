package _pro_backend.controller;

import _pro_backend.entity.Session;
import _pro_backend.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SessionController {

    private final SessionService service;

    @PostMapping
    public Session create(@RequestBody Session s) {
        return service.create(s);
    }

    @PutMapping("/start/{id}")
    public Session start(@PathVariable int id) {
        return service.start(id);
    }

    @PutMapping("/end/{id}")
    public Session end(@PathVariable int id) {
        return service.end(id);
    }

    @GetMapping
    public List<Session> all() {
        return service.getAll();
    }
}