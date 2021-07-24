package com.likhalikhi.model;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "post_id")
    public Long id;

    @Column(name = "post_title")
    public String title;

    @Column(name = "post_body")
    public String body;

    public Long getPost_id() {
        return id;
    }

    public void setPost_id(Long post_id) {
        this.id = post_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
