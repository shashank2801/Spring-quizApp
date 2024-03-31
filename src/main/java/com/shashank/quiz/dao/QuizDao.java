package com.shashank.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shashank.quiz.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
