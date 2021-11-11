package eu.kocka.jeopardyBackEnd.mapper;

import eu.kocka.jeopardyBackEnd.dto.GameDto;
import eu.kocka.jeopardyBackEnd.entity.Game;

import java.util.ArrayList;
import java.util.List;

public class GameMapper {

    public GameDto mapToDto(Game game){
        return new GameDto(game.getId(), game.getGameName());
    }

    public List<GameDto> mapListToDtos(List<Game> games){
        List<GameDto> dtos = new ArrayList<>();
        games.forEach(g -> dtos.add(new GameDto(g.getId(), g.getGameName())));
        return dtos;
    }

    public GameDto mapWholeGame(Game game){
        CategoryMapper categoryMapper = new CategoryMapper();
        return new GameDto(game.getId(), game.getGameName(), categoryMapper.mapCategoriesWithQuestions(game.getCategories()));
    }
}
