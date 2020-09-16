package by.bsuir.Kulinka.controller;

import by.bsuir.Kulinka.interfaces.PlanRepository;
import by.bsuir.Kulinka.model.entity.Abonent;
import by.bsuir.Kulinka.interfaces.AbonentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AbonentsCotroller
{
    //------------------------------------------------------------------------------------------------------------------
    @Autowired
    AbonentRepository abonentRepository;
    //------------------------------------------------------------------------------------------------------------------
    @GetMapping(path = "/getAbons")
    public List<Abonent> getAllAbons()
    {
        return abonentRepository.findAll();
    }
    //------------------------------------------------------------------------------------------------------------------
    //@GetMapping
    //@Query(value = "", nativeQuery = true)
    //public
}
