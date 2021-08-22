package com.likhalikhi.controller;

import com.likhalikhi.exception.ApiRequestException;
import com.likhalikhi.model.Post;
import com.likhalikhi.service.PostService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/posts")
public class PostController {

    Logger logger = Logger.getLogger(PostController.class);

    @Autowired
    PostService postService;

    static final Logger log =  Logger.getLogger(PostController.class);

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<Iterable<Post>>(postService.findAll(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> create( @Valid @RequestBody Post post ) {
        Post savedPost = postService.save(post);
        return new ResponseEntity<Post>(savedPost,HttpStatus.CREATED);

    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> findPost( @PathVariable("postId") Long postId ) {
        return new ResponseEntity<Post>(postService.findById(postId),HttpStatus.OK);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Post> update( @Valid @RequestBody Post newPost, @PathVariable("postId") Long postId  ) {
        Post updatedPost = postService.update(newPost,postId);
        return new ResponseEntity<Post>(updatedPost, HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Object> delete( @PathVariable("postId") Long postId ) {
        postService.delete(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/new")
    public String showForm() {
        return "post/post-form.jsp";
    }




// TODO find users by session and establish the many to many between customer and post

}
