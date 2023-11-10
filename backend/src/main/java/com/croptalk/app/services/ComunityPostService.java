package com.croptalk.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.croptalk.app.models.ComunityPost;
import com.croptalk.app.repositories.ComunityPostRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ComunityPostService {
  private final ComunityPostRepository comunityPostRepository;

  public List<ComunityPost> getAllPosts() {
    return comunityPostRepository.findAll();
  }

  public Optional<ComunityPost> getPostById(String postId) {
    return comunityPostRepository.findById(postId);
  }

  public ComunityPost createPost(ComunityPost post) {
    return comunityPostRepository.insert(post);
  }

  public void deletePost(String postId){
     comunityPostRepository.deleteById(postId);
  }
}