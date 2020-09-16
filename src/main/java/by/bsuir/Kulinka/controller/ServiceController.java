package by.bsuir.Kulinka.controller;

import by.bsuir.Kulinka.interfaces.ServiceRepository;
import by.bsuir.Kulinka.model.entity.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController
{
    //------------------------------------------------------------------------------------------------------------------
    @Autowired
    ServiceRepository serviceRepository;
    //------------------------------------------------------------------------------------------------------------------
    //Получить все услуги
    @GetMapping(path = "/services")
    public List<Service> getAllServices()
    {
        return serviceRepository.findAll();
    }
    //------------------------------------------------------------------------------------------------------------------
    //Создать новую услугу
    @PostMapping(path = "/service/add")
    public Service createService(@RequestParam(name = "name") String name, @RequestParam(name = "cost") float cost)
    {
        Service service = new Service(name, cost);
        return serviceRepository.save(service);
    }
    //------------------------------------------------------------------------------------------------------------------
    //Удалить услугу
    @DeleteMapping(path = "/service/delete")
    public String deleteService(@RequestParam(name = "serviceid") int service_id)
    {
        Service service = serviceRepository.getOne(service_id);
        serviceRepository.delete(service);
        return "Deleted";
    }
    //------------------------------------------------------------------------------------------------------------------
}
