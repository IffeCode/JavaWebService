package org.example.springbootdemo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //samma som AUTO_INCREMENT
    private Long id = 0L;

    @Column(name = "name")
    @Size(min = 2, message = "Name must be atleast 2 characters long!")
    @NotBlank(message = "Name cannot be blank!")
    private String name = "";

    @Column(unique = true, nullable = false)
    //unique - kan inte skapa samma | nullable - får inte vara tom
    @NotEmpty
    @Pattern(regexp = "^\\+[1-9]\\d{1,14}$",
            message = "You have to enter the phone in international format (E.164)")
    private String phone = "";

    public Person() {

    }

    public Person(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
