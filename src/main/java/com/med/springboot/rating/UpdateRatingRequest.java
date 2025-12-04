package com.med.springboot.rating;

import lombok.Data;

@Data
public class UpdateRatingRequest {
    private Integer rating;
    private String feedback;
}
