package com.spring.service;

import com.spring.pojo.Post;

import java.util.List;

public interface ForumPostService {
    List<Post> findAll();

//    Page<Post> selectPostByPages(Integer pages, Integer rows);

    char savePost(Post post);

//    Page<Post> searchPost(String keywords, Integer pages, Integer rows);

    Post findById(String id);

    String updatePostId(Post postDetails);

    void deletePostById(String id);

    List<Post> searchStatement(String id);

    char saveStatement(Post post);

    void addnumbers(String postid);

    int addlikenumbers(Integer id);

    List<Post> searchPostByUsername(String username);

    List<String> searchPostidByUsername(String username);
}
