package eu.kocka.jeopardyBackEnd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    private Long id;
    private String text;
    private int worth;
    private Long categoryId;
    private boolean happyHour;
}
