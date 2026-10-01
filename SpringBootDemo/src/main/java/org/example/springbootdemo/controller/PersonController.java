package org.example.springbootdemo.controller;


import org.example.springbootdemo.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PersonController {

    @GetMapping
    public List<Person> list() {



        return List.of(new Person());

    }


}
