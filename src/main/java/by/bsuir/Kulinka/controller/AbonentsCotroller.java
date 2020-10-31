package by.bsuir.Kulinka.controller;

import by.bsuir.Kulinka.interfaces.abonents.AbonentRepository;
import by.bsuir.Kulinka.model.entity.abonents.Abonent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AbonentsCotroller
{
    //------------------------------------------------------------------------------------------------------------------
    @Autowired
    AbonentRepository abonentRepository;
    //------------------------------------------------------------------------------------------------------------------
    @GetMapping(path = "/abonents")
    public List<Abonent> getAllAbons()
    {
        return abonentRepository.findAll();
    }
    //------------------------------------------------------------------------------------------------------------------
    //@GetMapping
    //@Query(value = "", nativeQuery = true)
    //public
    //------------------------------------------------------------------------------------------------------------------
    //Создать абонента
    @PostMapping(path = "/abonent/create")
    public Abonent createAbonent(@RequestBody Abonent abonent)
    {
        return abonentRepository.save(abonent);
    }
    //------------------------------------------------------------------------------------------------------------------
    //Обновить абонента
    @PutMapping(path = "abonent/update")
    public Abonent updateAbonent(@RequestBody Abonent abonent)
    {
        return abonentRepository.save(abonent);
    }
    //------------------------------------------------------------------------------------------------------------------
    //Удалить абонента
    @DeleteMapping(path = "abonent/delete")
    public int deleteAbonent(@RequestParam(name = "abonid") int id)
    {
        try
        {
            abonentRepository.deleteById(id);
        } catch (Exception ex)
        {
            return -1;
        }
        return id;
    }
    //------------------------------------------------------------------------------------------------------------------
}
