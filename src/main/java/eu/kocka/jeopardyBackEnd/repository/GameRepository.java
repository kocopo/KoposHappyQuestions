package eu.kocka.jeopardyBackEnd.repository;

import eu.kocka.jeopardyBackEnd.entity.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GameRepository extends CrudRepository<Game, Long> {
    Optional<Game> findByGameName(String name);
    void deleteById(Long id);
}
