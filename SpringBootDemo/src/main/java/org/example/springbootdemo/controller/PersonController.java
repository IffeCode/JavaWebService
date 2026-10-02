package org.example.springbootdemo.controller;


import org.example.springbootdemo.model.Person;
import org.example.springbootdemo.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //List of all persons
    @GetMapping("person/")
    public List<Person> list() {

        return personService.listAll();
    }

    //Get a specifik person
    @GetMapping("person/{id}")
    public Person get(@PathVariable Long id) {
        return new Person();
    }

    //Post a person
    @PostMapping("person/")
    public void post(@RequestBody Person person){

    }

    //Update a person
    @PutMapping("person/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody Person person) {

        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    //Delete a person
    @DeleteMapping("person/{id}")
    public void delete(@PathVariable Long id) {

    }



}
