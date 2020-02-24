package com.example.project_01.dao;

import com.example.project_01.model.Person;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component("person_service_dao")
public class PersonImpl implements PersonDao {

    @Autowired
    private PersonRepo personRepo;

    @Override
    public Person insertPerson(UUID id, Person person) {
        return personRepo.saveAndFlush(new Person(id, person.getName()));
    }

    @Override
    public List<Person> selectAllPerson() {
        return personRepo.findAll();
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return personRepo.findById(id);
    }

    @Override
    public Optional<Person> DeletePersonById(UUID id) {
        Optional<Person> exist_person = personRepo.findById(id);
        personRepo.deleteById(id);
        return exist_person;
    }

    @Override
    public Person UpdatePersonById(UUID id, Person newPerson) {
        Optional<Person> exist_person = personRepo.findById(id);
        Person p = new Person(id, newPerson.getName());
        BeanUtils.copyProperties(exist_person, p);
        return personRepo.saveAndFlush(p);
    }
}
