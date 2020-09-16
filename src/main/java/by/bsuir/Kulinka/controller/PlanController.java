package by.bsuir.Kulinka.controller;

import by.bsuir.Kulinka.interfaces.PlanRepository;
import by.bsuir.Kulinka.interfaces.PlanServiceRepository;
import by.bsuir.Kulinka.interfaces.ServiceRepository;
import by.bsuir.Kulinka.model.PlanInfo;
import by.bsuir.Kulinka.model.entity.Plan;
import by.bsuir.Kulinka.model.entity.PlanService;
import by.bsuir.Kulinka.model.entity.Service;
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
    //Создать новый план
    @PostMapping(path = "/plan/add")
    public PlanInfo createPlan(@RequestBody PlanInfo planInfo)
    {
        Plan plan = addPlan(new Plan(planInfo.getName()));
        planInfo.setPlan_id(plan.getId());
        for (Service service : planInfo.getServices())
        {
            addPlanService(new PlanService(plan.getId(), service.getId()));
        }
        return planInfo;
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

    //------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------
}
