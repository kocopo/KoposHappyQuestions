package eu.kocka.jeopardyBackEnd.controller;

import eu.kocka.jeopardyBackEnd.dto.GameDto;
import eu.kocka.jeopardyBackEnd.entity.Game;
import eu.kocka.jeopardyBackEnd.exception.NotFoundException;
import eu.kocka.jeopardyBackEnd.mapper.GameMapper;
import eu.kocka.jeopardyBackEnd.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("game")
public class GameController {

    private final GameService gameService;
    private final GameMapper mapper;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
        this.mapper = new GameMapper();
    }

    @GetMapping("")
    public ResponseEntity<List<GameDto>> listAllGames(){
        return new ResponseEntity<>(mapper.mapListToDtos(gameService.listAllGames()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<GameDto> getGameById(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(mapper.mapToDto(gameService.getGameById(id)), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<GameDto> createGame(@RequestBody Game game){
        return new ResponseEntity<>(mapper.mapToDto(gameService.saveGame(game)), HttpStatus.CREATED);
    }

    @GetMapping("{id}/whole")
    public ResponseEntity<GameDto> getWholeGame(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(mapper.mapWholeGame(gameService.getGameById(id)), HttpStatus.OK);
    }

    @GetMapping("{name}/name")
    public ResponseEntity<GameDto> getGameByName(@PathVariable String name) throws NotFoundException {
        return new ResponseEntity<>(mapper.mapToDto(gameService.getGameByName(name)), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteGameById(@PathVariable Long id){
        gameService.deleteGameById(id);
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }
}
