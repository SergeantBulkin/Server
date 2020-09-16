package by.bsuir.Kulinka.interfaces;

import by.bsuir.Kulinka.model.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer>
{

}
