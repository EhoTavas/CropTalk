package com.croptalk.app.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.croptalk.app.models.IaQuestion;
import com.croptalk.app.repositories.IaQuestionRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class IaQuestionService {
  private final IaQuestionRepository iaQuestionRepository;

  public List<IaQuestion> getAllQuestions() {
    return iaQuestionRepository.findAll();
  }

  public Optional<IaQuestion> getQuestionById(String questionId) {
    return iaQuestionRepository.findById(questionId);
  }

  public IaQuestion createQuestion(IaQuestion question) {
    return iaQuestionRepository.insert(question);
  }

  public void deleteQuestion(String questionId){
     iaQuestionRepository.deleteById(questionId);
  }
}


