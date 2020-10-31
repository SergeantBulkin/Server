package by.bsuir.Kulinka.interfaces.quiz;

import by.bsuir.Kulinka.model.entity.quiz.AnswerDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerDB, Integer>
{
    @Query(value = "SELECT * FROM answers WHERE category_id = :category_id", nativeQuery = true)
    List<AnswerDB> findAllFromCategory(@Param("category_id") int category_id);

    @Query(value = "SELECT * FROM answers WHERE answers.question_id = :question_id", nativeQuery = true)
    List<AnswerDB> findAllFromQuestion(@Param("question_id") int question_id);
}
