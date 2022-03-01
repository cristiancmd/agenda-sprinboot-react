package com.example.demo.controller;

import com.example.demo.iServices.IPersonService;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", allowedHeaders = "*")

@Controller
@RestController
@RequestMapping("/api/")

public class PersonController {

    private final IPersonService service;

    @Autowired
    public PersonController ( IPersonService service ) {
        this.service = service;
    }


    @GetMapping( "/persons" )
    public List<Person> getAll(){
        return service.list();
    }

    @PostMapping( "/persons" )
    public ResponseEntity<?> createPerson ( @RequestBody
                                                    Person person){
        return ResponseEntity.ok(this.service.save(person));

    }


    @GetMapping( "/persons/{id}" )
    public ResponseEntity<Person> getPerson ( @PathVariable Long id)  {
        Optional<Person> person = this.service.listById(id);
        return person.map(value -> new ResponseEntity<>(value , HttpStatus.OK)).orElseGet(() -> ResponseEntity.notFound().build());

    }


    @PutMapping( "/persons/{id}" )
    public ResponseEntity<Person> updatePerson ( @PathVariable Long id,
                                                 @RequestBody
                                                          Person personDetail ){

        Person person = this.service.update(id, personDetail);
        if(person !=null)
            return new ResponseEntity<>(person , HttpStatus.CREATED);
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping( "persons/{id}" )
    public ResponseEntity<?> delete(@PathVariable Long id){

        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
