package by.bsuir.Kulinka.interfaces.abonents;

import by.bsuir.Kulinka.model.entity.abonents.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer>
{

}
