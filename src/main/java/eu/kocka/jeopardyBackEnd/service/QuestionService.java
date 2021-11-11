package eu.kocka.jeopardyBackEnd.service;

import eu.kocka.jeopardyBackEnd.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestionService {
    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
}
