package com.openchowski.library.service;

import com.openchowski.library.dao.PersonRepo;
import com.openchowski.library.entity.Person;
import com.openchowski.library.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepo personRepo;


    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public List<Person> findAll() {
        return personRepo.findAll();
    }

    public Optional<Person> findById(int id) {
        return personRepo.findById(id);
    }

    public void deleteById(int id){
        personRepo.deleteById(id);
    }

    public Person save(Person person){
        return personRepo.save(person);
    }

}
