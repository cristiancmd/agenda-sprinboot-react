package com.example.demo.interfaces;

import com.example.demo.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPerson extends CrudRepository<Person, Long> {

}
