package eu.kocka.jeopardyBackEnd.service;

import eu.kocka.jeopardyBackEnd.entity.Category;
import eu.kocka.jeopardyBackEnd.entity.Question;
import eu.kocka.jeopardyBackEnd.exception.NotFoundException;
import eu.kocka.jeopardyBackEnd.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;
    private CategoryService categoryService;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, CategoryService categoryService) {
        this.questionRepository = questionRepository;
        this.categoryService = categoryService;
    }

    public Question saveQuestion(Question question, Long id) throws NotFoundException {
        Category category = categoryService.findCategoryById(id);
        question.setCategory(category);
        return questionRepository.save(question);
    }

    public List<Question> listAllQuestions(){
        List<Question> questions = new ArrayList<>();
        questionRepository.findAll().forEach(questions::add);
        return questions;
    }

    public List<Question> findAllQuestionsByCategoryId(Long id){
        return questionRepository.findAllByCategory_Id(id);
    }

    public Question findQuestionById(Long id) throws NotFoundException {
        return questionRepository.findById(id).orElseThrow(() -> new NotFoundException("Question not found with id : " + id));
    }

    public List<Question> batchSaveQuestions(List<Question> questions, Long categoryId) throws NotFoundException {
        Category category = categoryService.findCategoryById(categoryId);

        questions.forEach(q -> q.setCategory(category));
        List<Question> savedQuestions = new ArrayList<>();
        questionRepository.saveAll(questions).forEach(savedQuestions::add);

        return savedQuestions;
    }

    public void deleteQuestionById(Long id){
        questionRepository.deleteById(id);
    }

    public void deleteQuestion(Question question){
        questionRepository.delete(question);
    }
}
