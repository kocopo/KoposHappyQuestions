package eu.kocka.jeopardyBackEnd.repository;

import eu.kocka.jeopardyBackEnd.enitity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAllByGame_Id(Long id);
    void deleteById(Long id);
}
