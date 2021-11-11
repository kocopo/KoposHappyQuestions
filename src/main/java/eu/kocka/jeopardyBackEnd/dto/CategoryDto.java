package eu.kocka.jeopardyBackEnd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    public CategoryDto(Long id, String categoryName, Long gameId) {
        this.id = id;
        this.categoryName = categoryName;
        this.gameId = gameId;
    }

    private Long id;
    private String categoryName;
    private Long gameId;
    private List<QuestionDto> questions;
}
