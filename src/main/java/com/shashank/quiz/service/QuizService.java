package com.shashank.quiz.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.shashank.quiz.model.Question;

public interface QuizService {
	public ResponseEntity<String> createQuiz(String category, int numQ, String title);
	
	public ResponseEntity<List<Question>> getQuizQuestions(int id);
}
