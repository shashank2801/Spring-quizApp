package com.shashank.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shashank.quiz.model.Question;
import com.shashank.quiz.service.QuestionService;

@RestController
@RequestMapping("questions")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("getAllQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
		return questionService.getQuestionByCategory(category);
		
	}
	
	@PostMapping("addQuestion")
	public ResponseEntity<String> postQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);

	}
	
	
}
