package by.bsuir.Kulinka.interfaces.abonents;

import by.bsuir.Kulinka.model.entity.abonents.PlanService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanServiceRepository extends JpaRepository<PlanService, Integer>
{
    @Query(value = "SELECT * FROM plan_service WHERE plan_service.plan_id = :id", nativeQuery = true)
    List<PlanService> getPlanServiceByPlanID(@Param("id") int id);
}
