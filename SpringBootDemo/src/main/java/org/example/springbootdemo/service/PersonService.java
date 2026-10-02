package org.example.springbootdemo.service;

import org.example.springbootdemo.model.Person;
import org.example.springbootdemo.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//Transactional från Spring Boot inte Jakarta
@Transactional
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> listAll() {
        return personRepository.findAll();
    }

    public Person get(Long id) {
        return personRepository.findById(id).get();
    }

}
