package com.shashank.quiz.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.shashank.quiz.model.Question;

public interface QuestionService {
	public ResponseEntity<List<Question>> getAllQuestions();
	
	public ResponseEntity<List<Question>> getQuestionByCategory(String category);
	
	public ResponseEntity<String> addQuestion(Question question);
}
