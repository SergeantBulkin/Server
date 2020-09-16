package by.bsuir.Kulinka.interfaces;

import by.bsuir.Kulinka.model.entity.TestAbonent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestAbonentRepository extends JpaRepository<TestAbonent, Integer>
{

}
