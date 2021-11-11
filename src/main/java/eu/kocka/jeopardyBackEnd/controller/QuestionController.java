package eu.kocka.jeopardyBackEnd.controller;

import eu.kocka.jeopardyBackEnd.dto.QuestionDto;
import eu.kocka.jeopardyBackEnd.entity.Question;
import eu.kocka.jeopardyBackEnd.exception.NotFoundException;
import eu.kocka.jeopardyBackEnd.mapper.QuestionMapper;
import eu.kocka.jeopardyBackEnd.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    
    private final QuestionService questionService;
    private final QuestionMapper mapper;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
        this.mapper = new QuestionMapper();
    }

    @PostMapping("category/{categoryId}")
    public ResponseEntity<QuestionDto> saveQuestion(@RequestBody Question question, @PathVariable Long categoryId) throws NotFoundException {
        return new ResponseEntity<>(mapper.mapToDto(questionService.saveQuestion(question, categoryId)), HttpStatus.OK);
    }

    @PostMapping("category/{categoryId}/batch")
    public ResponseEntity<List<QuestionDto>> saveBatchQuestions(@RequestBody List<Question> questions, @PathVariable Long categoryId) throws NotFoundException {
        return new ResponseEntity<>(mapper.mapListToDtos(questionService.batchSaveQuestions(questions, categoryId)), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<QuestionDto>> listAllQuestions(){
        return new ResponseEntity<>(mapper.mapListToDtos(questionService.listAllQuestions()), HttpStatus.OK);
    }

    @GetMapping("category/{categoryId}")
    public ResponseEntity<List<QuestionDto>> getQuestionsByGameId(@PathVariable Long categoryId){
        return new ResponseEntity<>(mapper.mapListToDtos(questionService.findAllQuestionsByCategoryId(categoryId)), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<QuestionDto> getQuestionById(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(mapper.mapToDto(questionService.findQuestionById(id)),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteQuestionById(@PathVariable Long id){
        questionService.deleteQuestionById(id);
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }
}
