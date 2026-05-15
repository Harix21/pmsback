package _pro_backend.service;

import _pro_backend.entity.Session;
import _pro_backend.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository repo;

    @Override
    public Session create(Session s) {
        s.setActive(false);
        return repo.save(s);
    }

    @Override
    public Session start(int id) {
        Session s = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        s.setActive(true);
        return repo.save(s);
    }

    @Override
    public Session end(int id) {
        Session s = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        s.setActive(false);
        return repo.save(s);
    }

    @Override
    public List<Session> getAll() {
        return repo.findAll();
    }
}