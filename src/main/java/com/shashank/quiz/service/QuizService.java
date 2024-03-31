package com.shashank.quiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shashank.quiz.dao.QuestionDao;
import com.shashank.quiz.dao.QuizDao;
import com.shashank.quiz.model.Question;
import com.shashank.quiz.model.Quiz;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		
		return new ResponseEntity<String>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<Question>> getQuizQuestions(int id) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz = quizDao.findById(id);
		return new ResponseEntity<List<Question>>(quiz.get().getQuestions(),HttpStatus.OK);
	}
}
