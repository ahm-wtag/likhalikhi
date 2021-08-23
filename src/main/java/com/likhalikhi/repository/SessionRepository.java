package com.likhalikhi.repository;

import com.likhalikhi.model.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.UUID;

@Repository
public class SessionRepository {

    @PersistenceContext
    EntityManager entityManager;

    public UUID save(Session session) {
        entityManager.persist(session);
        return session.getSession_id();
    }

    public Long findUserSession ( UUID session_id ) {

        try {
            Session session = findById(session_id);
            return session.getCustomer_id();
        }catch (NoResultException e) {
            return -1L;
        }

    }

    public Session findById ( UUID session_id ) {

        TypedQuery<Session> query = entityManager.createQuery("select s from Session s where s.session_id=:session_id",Session.class);
        query.setParameter("session_id",session_id);
        return query.getSingleResult();

    }

    public void delete( UUID session_id) {
        Session session = findById(session_id);
        entityManager.remove(session);
    }

}
