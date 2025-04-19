package com.bearhive.bearhive.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bearhive.bearhive.Model.Dictation;

@Repository
public interface DictationRepository extends JpaRepository<Dictation, Long> {
    
}
