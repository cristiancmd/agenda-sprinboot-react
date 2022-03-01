package com.example.demo.iServices;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonService {

    public List<Person> list();
    Optional<Person> listById( Long id);
    public Person save( Person e);
    public Person update( Long id, Person e);
    public void delete( Long id);
}
