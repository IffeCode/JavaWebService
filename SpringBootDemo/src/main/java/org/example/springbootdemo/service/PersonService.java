package org.example.springbootdemo.service;

import org.example.springbootdemo.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//Transactional från Spring Boot inte Jakarta
@Transactional
public class PersonService {

    public List<Person> listAll() {
        return
    }

}
