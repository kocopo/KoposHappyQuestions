package eu.kocka.jeopardyBackEnd.controller;

import eu.kocka.jeopardyBackEnd.dto.CommonDto;
import eu.kocka.jeopardyBackEnd.dto.GameDto;
import eu.kocka.jeopardyBackEnd.enitity.Game;
import eu.kocka.jeopardyBackEnd.mapper.GameMapper;
import eu.kocka.jeopardyBackEnd.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("game")
public class GameController {

    private GameService gameService;
    private GameMapper mapper;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
        this.mapper = new GameMapper();
    }

    @GetMapping("")
    public List<Game> listAllGames(){
        return gameService.listAllGames();
    }

    @GetMapping("{id}")
    public CommonDto getGameById(@PathVariable Long id){
        Game game = gameService.getGameById(id);
        if(game == null){
            return new CommonDto("Game not Found");
        }else{
            return mapper.mapToDto(game);
        }
    }

    @PostMapping("")
    public Game createGame(@RequestBody Game game){
        return gameService.saveGame(game);
    }
}
