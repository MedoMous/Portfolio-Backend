package com.med.springboot.question;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "questions")
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(length = 1000 , nullable = false)
    private String question;

    @Column(length = 100 , nullable = false)
    private String name;

    @Column(length = 1000)
    private String answer;

    @Column(name = "created_at::timestamp(2)")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "boolean default false")
    private Boolean answered;

    @PrePersist
    public void OnCreate(){
        this.createdAt = LocalDateTime.now();
        if(this.answered == null){
            this.answered = false;
        }
    }
}
