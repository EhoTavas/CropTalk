package com.croptalk.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.croptalk.app.models.Solutions;
import com.croptalk.app.services.SolutionsService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/solutions")
@AllArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500") //endereço do frontend
public class SolutionsController {
  private final SolutionsService solutionsService;

  @GetMapping
  public ResponseEntity<List<Solutions>> getAllSolutions() {
    List<Solutions> solutions = solutionsService.getAllSolutions();

    if (!solutions.isEmpty()) {
      return ResponseEntity.ok(solutions);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/{solutionId}")
  public ResponseEntity<Solutions> getSolutionById(@PathVariable String solutionId) {
    Optional<Solutions> solutionOptional = solutionsService.getSolutionById(solutionId);
    Solutions solution = solutionOptional.orElse(null);

    return solution != null ? ResponseEntity.ok(solution) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<Solutions> createSolution(@RequestBody Solutions newSolution) {
    if (newSolution == null) {
      return ResponseEntity.badRequest().build(); // 400 Bad Request
    }

    Solutions createdSolution = solutionsService.createSolution(newSolution);
    return new ResponseEntity<>(createdSolution, HttpStatus.CREATED);
  }
}

