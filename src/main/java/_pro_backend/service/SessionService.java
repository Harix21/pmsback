package _pro_backend.service;

import _pro_backend.entity.Session;

import java.util.List;

public interface SessionService {

    Session create(Session session);

    Session start(int id);

    Session end(int id);

    List<Session> getAll();
}