package com.med.springboot.question;

import com.med.springboot.rating.UpdateRatingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
@CrossOrigin(origins = "http://localhost:5173")
public class QuestionController {
    @Autowired
    private QuestionService service;

    @GetMapping
    public List<Question> findAll(){
        return service.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Question findById(
            @PathVariable Long id){
        return service.getQuestionById(id);
    }

    @PostMapping
    public Question save(
            @RequestBody Question question){
        return service.saveQuestion(question);
    }

    @PutMapping("/{id}")
    public Question edit(
            @PathVariable Long id ,
            @RequestBody UpdateQuestion question){
        return service.editQuestion(id , question);
    }

    @PutMapping("/{id}/answered")
    public Question answer(
            @PathVariable Long id,
            @RequestBody AnswerRequest answer){
        return service.answerQuestion(id , answer);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(
            @PathVariable Long id){
        service.deleteQuestion(id);
    }
}
