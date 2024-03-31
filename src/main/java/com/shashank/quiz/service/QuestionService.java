package com.shashank.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shashank.quiz.dao.QuestionDao;
import com.shashank.quiz.model.Question;

@ComponentScan("com.shashank.quiz.dao")
@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<List<Question>> getAllQuestions() {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
	}


	public ResponseEntity<String> addQuestion(Question question) {
		// TODO Auto-generated method stub
		try{
			questionDao.save(question);
			return new ResponseEntity<>("Added",HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Bad Request",HttpStatus.BAD_REQUEST);
	}
	
}
