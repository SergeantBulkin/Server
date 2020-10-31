package by.bsuir.Kulinka.interfaces.quiz;

import by.bsuir.Kulinka.model.entity.quiz.CategoryDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDB, Integer>
{

}
