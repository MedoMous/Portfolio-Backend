package com.med.springboot.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ratings")
@CrossOrigin(origins = "http://localhost:5173")
public class RatingController {
    @Autowired
    private RatingService service;

    @GetMapping
    public List<Rating> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Rating findById(
            @PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public Rating submit(
            @RequestBody Rating rating){
        return service.submitRating(rating);
    }

    @PutMapping("/{id}/rating")
    public Rating update(
            @PathVariable Long id,@RequestBody UpdateRatingRequest request){
        return service.updateRating(id, request);
    }
}
