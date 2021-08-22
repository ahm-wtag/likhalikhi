package com.likhalikhi.service;

import com.likhalikhi.model.Post;
import com.likhalikhi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostService {

    @Autowired
    PostRepository repository;

    public Post save( Post post ) { return repository.save(post); }
    public List<Post> findAll() {
        return repository.findAll();
    }
    public Post findById(Long postId) { return repository.findById(postId);}
    public Post update( Post post, Long postId ) { return repository.update(post,postId);}
    public void delete( Long postId ) { repository.delete(postId);}

}
