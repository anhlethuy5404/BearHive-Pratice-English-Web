package com.bearhive.bearhive.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_dictation")
public class UserDictation {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    
    private String audio, text;

    @ManyToOne (fetch=jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "dictation_id")
    private Dictation dictation;

    @ManyToOne (fetch=jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
