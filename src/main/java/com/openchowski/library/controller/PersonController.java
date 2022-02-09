package com.openchowski.library.controller;

import com.openchowski.library.entity.Person;
import com.openchowski.library.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> findAll(){
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> findById(@PathVariable int id){
        return personService.findById(id);
    }

    @PostMapping
    public Person save(@RequestBody Person person){
        return personService.save(person);
    }

    @PutMapping("/{id}")
    public Person save(@PathVariable int id, @RequestBody Person newPerson){
        return personService.findById(id)
                .map(person -> {
                    person.setFirstName(newPerson.getFirstName());
                    person.setLastName(newPerson.getLastName());
                    return personService.save(person);
                })
                .orElseGet(() -> {
                    newPerson.setId(id);
                    return personService.save(newPerson);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        personService.deleteById(id);
    }

}
