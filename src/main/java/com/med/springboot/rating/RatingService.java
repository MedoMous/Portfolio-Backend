package com.med.springboot.rating;

import com.med.springboot.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    @Autowired
    private RatingRepository repository;

    public List<Rating> findAll(){
        return repository.findAll();
    }

    public Rating findById(
            Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rating not found!"));
    }

    public Rating submitRating(
            Rating rating){
        return repository.save(rating);
    }

    public Rating updateRating(
            Long id , UpdateRatingRequest request){
        Rating submitted = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rating not found!"));

        submitted.setRating(request.getRating());
        submitted.setFeedback(request.getFeedback());
        return repository.save(submitted);
    }
}
