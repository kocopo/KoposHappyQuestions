package eu.kocka.jeopardyBackEnd.repository;

import eu.kocka.jeopardyBackEnd.enitity.Category;
import eu.kocka.jeopardyBackEnd.enitity.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAllByGame_Id(Long id);
    List<Category> findAllByGame(Game game);
}
