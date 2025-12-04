package com.med.springboot.repository;

import com.med.springboot.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<Question, Long> {

}
