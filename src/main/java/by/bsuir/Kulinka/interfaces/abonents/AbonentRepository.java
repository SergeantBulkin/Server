package by.bsuir.Kulinka.interfaces.abonents;

import by.bsuir.Kulinka.model.entity.abonents.Abonent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonentRepository extends JpaRepository<Abonent, Integer>
{

}
