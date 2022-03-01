package com.example.demo.service;

import com.example.demo.iServices.IPersonService;
import com.example.demo.interfaces.IPerson;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements IPersonService {

    private final IPerson repo;
    @Autowired
    public PersonService ( IPerson repo ) {
        this.repo = repo;
    }


    @Override
    public List<Person> list () {
        return (List<Person>) this.repo.findAll();
    }

    @Override
    public Optional<Person> listById ( Long id ) {
        return this.repo.findById(id);
    }

    @Override
    public Person save ( Person e ) {
        return this.repo.save(e);
    }

    @Override
    public Person update ( Long id, Person e ) {
        Optional<Person> person = this.repo.findById(id);
        if(person.isPresent()){
            e.setId(id);
            return save(e);
        }
        return null;
    }


    @Override
    public void delete ( Long id ) {
        this.repo.deleteById(id);
    }
}
