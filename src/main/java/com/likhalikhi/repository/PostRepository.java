package com.likhalikhi.repository;

import com.likhalikhi.exception.ApiRequestException;
import com.likhalikhi.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

@Repository
public class PostRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Post save( Post post ) {
        try {
            entityManager.persist(post);
            return post;
        } catch ( Exception e ) {
            final String MESSAGE= "Failed to save in database";
            throw new ApiRequestException(MESSAGE,e);
        }
    }

    public List<Post> findAll() {
        try {
            Query query = entityManager.createQuery("SELECT post from Post post",Post.class);
            return (List<Post>) query.getResultList();
        }catch (Exception e ) {
            final String MESSAGE="Failed to retrieve posts";
            throw new ApiRequestException(MESSAGE, e);
        }
    }

    public Post findById( Long postId ) {
        try {
            Post post =  entityManager.find(Post.class, postId);
            if ( post == null ) {
                final String MESSAGE = "Invalid postId";
                throw new ApiRequestException(MESSAGE);
            }
            return post;
        }catch (ApiRequestException e) {
            throw new ApiRequestException(e.getMessage(),HttpStatus.BAD_REQUEST,e);
        }catch ( Exception e ) {
            final String MESSAGE = "Failed to get required post";
            throw new ApiRequestException(e);
        }
    }

    public Post update( Post newPost, Long postId ) {
        Post post = findById(postId);
        post.setTitle(newPost.title);
        post.setBody(newPost.body);
        return save(post);
    }

    public void delete( Long postId ) {
        Post postToDelete = findById(postId);
        entityManager.remove(postToDelete);
    }






}
