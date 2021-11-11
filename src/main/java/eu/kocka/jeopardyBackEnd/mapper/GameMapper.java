package eu.kocka.jeopardyBackEnd.mapper;

import eu.kocka.jeopardyBackEnd.dto.GameDto;
import eu.kocka.jeopardyBackEnd.enitity.Game;

public class GameMapper {

    public GameDto mapToDto(Game game){
        return new GameDto(game.getId(), game.getGameName(), game.getCategories());
    }
}
