package com.likhalikhi.repository;

import com.likhalikhi.model.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

@Repository
public class PostRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Post> findAll() {

        Query query = entityManager.createQuery("from Post");

        return (List<Post>)query.getResultList();

    }


}
