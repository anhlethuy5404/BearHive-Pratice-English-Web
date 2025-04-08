package com.bearhive.bearhive.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title, description, type, difficulty, coveredImage;
    private int questions;
    private LocalDate createdDate;
    private LocalDate updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDate.now();
    }

    public Test(String title, String description, String difficulty, String coveredImage, int questions, LocalDate updateDate, User user) {
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.coveredImage = coveredImage;
        this.questions = questions;
        this.updateDate = updateDate;
        this.user = user;
    }

}
