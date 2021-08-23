package com.likhalikhi.service;

import com.likhalikhi.model.Session;
import com.likhalikhi.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class SessionService {

    @Autowired
    SessionRepository repository;

    public UUID save(Session session ) {
        return repository.save(session);
    }

    public Long findUserSession ( UUID session_id ) {
        return  repository.findUserSession(session_id);
    }

    public Session findById ( UUID session_id ) { return repository.findById(session_id);}

    public void delete( UUID session_id ) { repository.delete(session_id);}

}
