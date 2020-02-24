package com.example.project_01.dao;

import com.example.project_01.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    Person insertPerson(UUID id, Person person);

    default Person insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPerson();

    Optional<Person> selectPersonById(UUID id);

    Optional<Person> DeletePersonById(UUID id);

    Person UpdatePersonById(UUID id, Person person);
}
