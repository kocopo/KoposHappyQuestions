package eu.kocka.jeopardyBackEnd.repository;

import eu.kocka.jeopardyBackEnd.entity.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findAllByCategory_Id(Long id);
    void deleteById(Long id);
}
