package com.croptalk.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.croptalk.app.models.ComunityPost;
import com.croptalk.app.services.ComunityPostService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/comunityPosts")
@AllArgsConstructor
public class ComunityPostController {
  private final ComunityPostService comunityPostService;

  @GetMapping
  public ResponseEntity<List<ComunityPost>> getAllPosts() {
    List<ComunityPost> comunityPosts = comunityPostService.getAllPosts();

    if (!comunityPosts.isEmpty()) {
      return ResponseEntity.ok(comunityPosts);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/{comunityPostId}")  
  public ResponseEntity<ComunityPost> getPostById(@PathVariable String comunityPostId) {
    Optional<ComunityPost> comunityPostOptional = comunityPostService.getPostById(comunityPostId);
    ComunityPost post = comunityPostOptional.orElse(null);

    return post != null ? ResponseEntity.ok(post) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<ComunityPost> createPost(@RequestBody ComunityPost newPost) {
    // Check if the request body is null
    if (newPost == null) {
      return ResponseEntity.badRequest().build(); // 400 Bad Request
    }

    // Proceed with user creation logic
    ComunityPost createdPost = comunityPostService.createPost(newPost);
    return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
  }
}
