package com.shashank.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.shashank.quiz.model.Question;

@Service
public interface QuestionDao extends JpaRepository<Question, Integer> {
	
	List<Question> findByCategory(String category);
	
	@Query(value="Select * from Question q where q.category= :category ORDER BY RAND() LIMIT :numQ",nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String category,int numQ);

}
