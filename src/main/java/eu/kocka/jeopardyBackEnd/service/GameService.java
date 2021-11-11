package eu.kocka.jeopardyBackEnd.service;

import eu.kocka.jeopardyBackEnd.enitity.Game;
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

    public Game getGameByName(String name){
        return gameRepository.findByGameName(name).orElse(null);
    }

    public Game getGameById(Long id){
        return gameRepository.findById(id).orElse(null);
    }

    public Game saveGame(Game game){
        return gameRepository.save(game);
    }

    public List<Game> listAllGames(){
        List<Game> games = new ArrayList<>();
        gameRepository.findAll().forEach(games::add);
        return games;
    }
}
