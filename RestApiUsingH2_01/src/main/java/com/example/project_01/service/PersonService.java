package com.example.project_01.service;

import com.example.project_01.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonService {
    public Person addPerson(Person person);

    public List<Person> selectAllPerson();

    public Optional<Person> getPersonById(UUID id);

    public Optional<Person> deletePersonById(UUID id);

    public Person updatePersonById(UUID id, Person newPerson);
}
