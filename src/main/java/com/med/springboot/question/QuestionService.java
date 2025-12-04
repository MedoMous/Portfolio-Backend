package com.med.springboot.question;

import com.med.springboot.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuestionService {
    @Autowired
    private QuestionsRepository repository;

    public Question saveQuestion(Question question){
        question.setAnswered(false);
        return repository.save(question);
    }
    public List<Question> getAllQuestions(){
        return repository.findAll();
    }

    public Question getQuestionById(
            Long id){
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Question with id :"+id+" not found"));
    }

    public void deleteQuestion(Long id){
        repository.deleteById(id);
    }

    public Question answerQuestion(
            Long id , AnswerRequest answer){
        Question question = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question with id :"+id+" not found"));
        question.setAnswered(true);
        question.setAnswer(answer.getAnswer());

        return repository.save(question);
    }

    public Question editQuestion(
            Long id,
            UpdateQuestion newQuestion){
        Question question = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question with id :"+id+" not found"));

        question.setQuestion(newQuestion.getQuestion());
        return repository.save(question);
    }
}
