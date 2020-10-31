package by.bsuir.Kulinka.controller;

import by.bsuir.Kulinka.interfaces.abonents.ServiceRepository;
import by.bsuir.Kulinka.model.entity.abonents.Service;
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
    @PostMapping(path = "/service/create")
    public Service createService(@RequestParam(name = "name") String name, @RequestParam(name = "cost") float cost)
    {
        Service service = new Service(name, cost);
        return serviceRepository.save(service);
    }
    //Создать новую услугу
    @PostMapping(path = "/service/create/body")
    public Service createService(@RequestBody Service service)
    {
        return serviceRepository.save(service);
    }
    //------------------------------------------------------------------------------------------------------------------
    //Удалить услугу (если не найден ID, вернётся -1)
    @DeleteMapping(path = "/service/delete")
    public int deleteService(@RequestParam(name = "serviceid") int service_id)
    {
        try
        {
            serviceRepository.deleteById(service_id);
        } catch (Exception ex)
        {
            return -1;
        }
        return service_id;
    }
    //------------------------------------------------------------------------------------------------------------------
    //Обновить услугу
    @PutMapping(path = "/service/update")
    public Service updateService(@RequestBody Service service)
    {
        return serviceRepository.save(service);
    }
    //------------------------------------------------------------------------------------------------------------------
}
