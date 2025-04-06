package com.sba.board.controller;

import com.sba.board.entity.Post;
import com.sba.board.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    // create a new post
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    // get all posts
    @GetMapping
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    // update a post by ID
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        return postRepository.findById(id)
                .map(post -> {
                    post.setTitle(updatedPost.getTitle());
                    post.setContent(updatedPost.getContent());
                    return postRepository.save(post);
                }).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    // delete a post by ID
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
    }
}