package eu.kocka.jeopardyBackEnd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameDto {

    public GameDto(Long id, String gameName) {
        this.id = id;
        this.gameName = gameName;
    }

    private Long id;
    private String gameName;
    private List<CategoryDto> categories;
}
