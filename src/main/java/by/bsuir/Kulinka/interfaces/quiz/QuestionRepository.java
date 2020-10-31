package by.bsuir.Kulinka.interfaces.quiz;

import by.bsuir.Kulinka.model.entity.quiz.QuestionDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionDB, Integer>
{
    @Query(value = "SELECT * FROM questions WHERE category_id = :category_id", nativeQuery = true)
    List<QuestionDB> findAllFromCategory(@Param("category_id") int category_id);
}
