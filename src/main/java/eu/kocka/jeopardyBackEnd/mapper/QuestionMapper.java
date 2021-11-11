package eu.kocka.jeopardyBackEnd.mapper;

import eu.kocka.jeopardyBackEnd.dto.QuestionDto;
import eu.kocka.jeopardyBackEnd.entity.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionMapper {

    public QuestionDto mapToDto(Question question){
        return new QuestionDto(question.getId(), question.getText(), question.getWorth(), question.getCategory().getId(), question.isHappyHour());
    }

    public List<QuestionDto> mapListToDtos(List<Question> questions){
        List<QuestionDto> dtos = new ArrayList<>();
        questions.forEach(q -> dtos.add(new QuestionDto(q.getId(), q.getText(), q.getWorth(), q.getCategory().getId(), q.isHappyHour())));
        return dtos;
    }
}
