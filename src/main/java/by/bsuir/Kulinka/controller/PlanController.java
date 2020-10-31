package by.bsuir.Kulinka.controller;

import by.bsuir.Kulinka.interfaces.abonents.PlanRepository;
import by.bsuir.Kulinka.interfaces.abonents.PlanServiceRepository;
import by.bsuir.Kulinka.interfaces.abonents.ServiceRepository;
import by.bsuir.Kulinka.model.PlanInfo;
import by.bsuir.Kulinka.model.entity.abonents.Plan;
import by.bsuir.Kulinka.model.entity.abonents.PlanService;
import by.bsuir.Kulinka.model.entity.abonents.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlanController
{
    //------------------------------------------------------------------------------------------------------------------
    @Autowired
    PlanRepository planRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    PlanServiceRepository planServiceRepository;
    //------------------------------------------------------------------------------------------------------------------
    //Получить все планы из БД
    @GetMapping(path = "/plans")
    public List<Plan> getAllPlans()
    {
        return planRepository.findAll();
    }
    //------------------------------------------------------------------------------------------------------------------
    //Получить план по ID
    @GetMapping(path = "/plan")
    public Plan getPlan(@RequestParam(name = "planid") int id)
    {
        return planRepository.getOne(id);
    }
    //------------------------------------------------------------------------------------------------------------------
    //Получить все объекты PlansInfo
    @GetMapping(path = "/plans/info")
    public List<PlanInfo> getAllPlansInfo()
    {
        List<PlanInfo> plansInfo = new ArrayList<>();
        List<Service> services;
        for (Plan plan : getAllPlans())
        {
            services = getPlanServices(plan.getId());
            plansInfo.add(new PlanInfo(plan.getId(), plan.getPlan_name(), services, countPlanCost(services)));
        }
        return plansInfo;
    }
    //------------------------------------------------------------------------------------------------------------------
    //Получить полную информацию о плане по ID
    @GetMapping(path = "/plan/info")
    public PlanInfo getPlanInfo(@RequestParam(name = "planid") int plan_id)
    {
        Plan plan = getPlan(plan_id);
        List<Service> services = getPlanServices(plan_id);
        return new PlanInfo(plan.getId(), plan.getPlan_name(), services, countPlanCost(services));
    }
    //------------------------------------------------------------------------------------------------------------------
    //Создать новый план
    @PostMapping(path = "/plan/add")
    public PlanInfo createPlan(@RequestBody PlanInfo planInfo)
    {
        //Создать план с таким же названием
        Plan plan = addPlan(new Plan(planInfo.getName()));
        //Запомнить id созданного плана
        planInfo.setPlan_id(plan.getId());
        //Создать записи в таблице plan_info
        for (Service service : planInfo.getServices())
        {
            addPlanService(new PlanService(plan.getId(), service.getId()));
        }
        return planInfo;
    }
    //------------------------------------------------------------------------------------------------------------------
    //Обновить тарифный план
    @PutMapping(path = "/plan/update")
    public PlanInfo updatePlan(@RequestBody PlanInfo planInfo)
    {
        //Удалить связанные с планом записи в таблице plan_info
        deletePlanServices(planInfo.getPlan_id());

        //Создать план для обновления в таблице plan
        Plan plan = new Plan(planInfo.getName());
        plan.setId(planInfo.getPlan_id());

        //Создать новые записи в таблице plan_service
        for (Service service : planInfo.getServices())
        {
            planServiceRepository.save(new PlanService(planInfo.getPlan_id(), service.getId()));
        }

        //Создать и вернуть созданный план
        planRepository.save(plan);
        return planInfo;
    }
    //------------------------------------------------------------------------------------------------------------------
    //Удалить тарифный план
    @DeleteMapping(path = "/plan/delete")
    public int deletePlan(@RequestParam(name = "planid") int planid)
    {
        //Удалить связанные с планом записи в таблице plan_info
        deletePlanServices(planid);

        try
        {
            planRepository.deleteById(planid);
        } catch (Exception ex)
        {
            return -1;
        }
        return planid;
    }
    //------------------------------------------------------------------------------------------------------------------
    //Добавить запись в таблицу plan
    private Plan addPlan(Plan plan)
    {
        return planRepository.save(plan);
    }
    //------------------------------------------------------------------------------------------------------------------
    //Добавить запись в таблицу plan_service
    private void addPlanService(PlanService planService)
    {
        planServiceRepository.save(planService);
    }
    //------------------------------------------------------------------------------------------------------------------
    //Получить список услуг, которые есть в указанном тарифе
    private List<Service> getPlanServices(int plan_id)
    {
        List<Service> services = new ArrayList<>();
        for (PlanService planService : planServiceRepository.getPlanServiceByPlanID(plan_id))
        {
            services.add(getServiceByID(planService.getService_id()));
        }
        return services;
    }
    //------------------------------------------------------------------------------------------------------------------
    //Вычислить стоимость тарифного плана
    private float countPlanCost(List<Service> services)
    {
        float cost = 0F;
        for (Service service : services)
        {
            cost += service.getCost();
        }
        return cost;
    }
    //------------------------------------------------------------------------------------------------------------------
    //Получить услугу по ID
    private Service getServiceByID(int service_id)
    {
        return serviceRepository.getOne(service_id);
    }
    //------------------------------------------------------------------------------------------------------------------
    //Удалить все записи из таблицы plan_service по id плана
    private void deletePlanServices(int planID)
    {
        List<PlanService> planServicesToDelete = planServiceRepository.getPlanServiceByPlanID(planID);

        for (PlanService planService : planServicesToDelete)
        {
            planServiceRepository.deleteById(planService.getId());
        }
    }
    //------------------------------------------------------------------------------------------------------------------
}
