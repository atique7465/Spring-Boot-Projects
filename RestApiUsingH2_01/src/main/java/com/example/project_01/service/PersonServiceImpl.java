package com.example.project_01.service;

import com.example.project_01.dao.PersonDao;
import com.example.project_01.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component("person_service")
public class PersonServiceImpl implements PersonService{
    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(@Qualifier("person_service_dao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> selectAllPerson(){
        return personDao.selectAllPerson();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public Optional<Person> deletePersonById(UUID id){
        return personDao.DeletePersonById(id);
    }

    public Person updatePersonById(UUID id, Person newPerson){
        return personDao.UpdatePersonById(id, newPerson);
    }
}
