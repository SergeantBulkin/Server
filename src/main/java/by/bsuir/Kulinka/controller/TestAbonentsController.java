package by.bsuir.Kulinka.controller;

import by.bsuir.Kulinka.model.entity.TestAbonent;
import by.bsuir.Kulinka.exception.AbonentNotFoundException;
import by.bsuir.Kulinka.interfaces.TestAbonentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestAbonentsController
{
    //------------------------------------------------------------------------------------------------------------------
    @Autowired
    TestAbonentRepository testAbonentRepository;
    //------------------------------------------------------------------------------------------------------------------
    //Добавить абонента
    @PostMapping(path = "/add")
    public TestAbonent addNewUser(@RequestParam("name") String name, @RequestParam("email") String email)
    {
        TestAbonent testAbonent = new TestAbonent(name, email);
        testAbonentRepository.save(testAbonent);
        return testAbonent;
    }
    //------------------------------------------------------------------------------------------------------------------
    @GetMapping(path = "/all")
    public List<TestAbonent> getAllAbonents()
    {
        return testAbonentRepository.findAll();
    }
    //------------------------------------------------------------------------------------------------------------------
    @PutMapping(path = "/update")
    public TestAbonent updateAbonent(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("email") String email) throws AbonentNotFoundException
    {
            TestAbonent testAbonent = testAbonentRepository.findById(id).orElseThrow(() -> new AbonentNotFoundException(id));
            testAbonent.setName(name);
            testAbonent.setEmail(email);
            testAbonentRepository.save(testAbonent);
            return testAbonent;
    }
    //------------------------------------------------------------------------------------------------------------------
    @DeleteMapping(path = "/delete")
    public String deleteAbonent(@RequestParam(name = "id") int id) throws AbonentNotFoundException
    {
        TestAbonent testAbonent = testAbonentRepository.findById(id).orElseThrow(() -> new AbonentNotFoundException(id));
        testAbonentRepository.delete(testAbonent);
        return "Deleted";
    }
    //------------------------------------------------------------------------------------------------------------------
}
