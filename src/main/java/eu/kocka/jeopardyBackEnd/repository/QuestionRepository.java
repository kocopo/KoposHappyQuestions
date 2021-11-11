package eu.kocka.jeopardyBackEnd.repository;

import eu.kocka.jeopardyBackEnd.enitity.Category;
import eu.kocka.jeopardyBackEnd.enitity.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findAllByCategory(Category category);
    List<Question> findAllByCategory_Id(Long id);
}
