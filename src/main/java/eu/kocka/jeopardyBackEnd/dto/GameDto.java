package eu.kocka.jeopardyBackEnd.dto;

import eu.kocka.jeopardyBackEnd.enitity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameDto extends CommonDto {
    private Long id;
    private String gameName;
    private List<Category> categories;
}
