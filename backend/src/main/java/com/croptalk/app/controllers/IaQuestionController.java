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

import com.croptalk.app.models.IaQuestion;
import com.croptalk.app.services.IaQuestionService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/iaQuestions")
@AllArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500") //endereço do frontend
public class IaQuestionController {
  private final IaQuestionService iaQuestionService;

  //get para procurar todas as perguntas
  @GetMapping
  public ResponseEntity<List<IaQuestion>> getAllQuestions() {
    List<IaQuestion> iaQuestions = iaQuestionService.getAllQuestions();

    // Check if there are questions
    if (!iaQuestions.isEmpty()) {
      // If users found, return them with a 200 OK status
      return ResponseEntity.ok(iaQuestions);
    } else {
      // If no questions found, return a 404 Not Found status
      return ResponseEntity.notFound().build();
    }
  }

  //get para procurar uma pergunta específica pelo id
  @GetMapping("/{iaQuestionId}")
  public ResponseEntity<IaQuestion> getQuestionById(@PathVariable String questionId) {
    Optional<IaQuestion> iaQuestionOptional = iaQuestionService.getQuestionById(questionId);
    IaQuestion iaQuestion = iaQuestionOptional.orElse(null);

    return iaQuestion != null ? ResponseEntity.ok(iaQuestion) : ResponseEntity.notFound().build();
  }

  //post para criação da pergunta
  @PostMapping
  public ResponseEntity<IaQuestion> createQuestion(@RequestBody IaQuestion newQuestion) {
    // Check if the request body is null
    if (newQuestion == null) {
      return ResponseEntity.badRequest().build(); // 400 Bad Request
    }

    // Proceed with user creation logic
    IaQuestion createdQuestion = iaQuestionService.createQuestion(newQuestion);
    return new ResponseEntity<>(createdQuestion, HttpStatus.CREATED);
  }
}
