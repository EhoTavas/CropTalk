package com.croptalk.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.croptalk.app.models.Solutions;
import com.croptalk.app.repositories.SolutionsRepository;


import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolutionsService {
  private final SolutionsRepository solutionsRepository;

  public List<Solutions> getAllSolutions() {
    return solutionsRepository.findAll();
  }

  public Optional<Solutions> getSolutionById(String solutionId) {
    return solutionsRepository.findById(solutionId);
  }

  public Solutions createSolution(Solutions solution) {
    return solutionsRepository.insert(solution);
  }

  public void deleteSolution(String solutionId){
     solutionsRepository.deleteById(solutionId);
  }
}
