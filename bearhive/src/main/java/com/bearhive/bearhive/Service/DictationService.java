package com.bearhive.bearhive.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bearhive.bearhive.Model.Dictation;
import com.bearhive.bearhive.Repository.DictationRepository;

@Service
public class DictationService {
    @Autowired
    private DictationRepository dictationRepository;

    public List<Dictation> getAllDictations() {
        return dictationRepository.findAll();
    }
}
