package eu.kocka.jeopardyBackEnd.service;

import eu.kocka.jeopardyBackEnd.enitity.Game;
import eu.kocka.jeopardyBackEnd.exception.NotFoundException;
import eu.kocka.jeopardyBackEnd.repository.CategoryRepository;
import eu.kocka.jeopardyBackEnd.repository.GameRepository;
import eu.kocka.jeopardyBackEnd.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {


    private GameRepository gameRepository;
    private CategoryRepository categoryRepository;
    private QuestionRepository questionRepository;

    @Autowired
    public GameService(GameRepository gameRepository, CategoryRepository categoryRepository, QuestionRepository questionRepository) {
        this.gameRepository = gameRepository;
        this.categoryRepository = categoryRepository;
        this.questionRepository = questionRepository;
    }

    public Game getGameByName(String name) throws NotFoundException {
        return gameRepository.findByGameName(name).orElseThrow(() -> new NotFoundException("Game not found with name : " + name));
    }

    public Game getGameById(Long id) throws NotFoundException {
        return gameRepository.findById(id).orElseThrow(() -> new NotFoundException("Game not found with id : " + id));
    }

    public Game saveGame(Game game){
        return gameRepository.save(game);
    }

    public List<Game> listAllGames(){
        List<Game> games = new ArrayList<>();
        gameRepository.findAll().forEach(games::add);
        return games;
    }

    public void deleteGameById(Long id){
        gameRepository.deleteById(id);
    }

    public void deleteGame(Game game){
        gameRepository.delete(game);
    }
}
