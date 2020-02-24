package com.example.project_01.api;

import com.example.project_01.model.Person;
import com.example.project_01.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(@Qualifier("person_service") PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.selectAllPerson();
    }

    @GetMapping(value = "/{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePersonById(id);
    }

    @PutMapping(value = "/{id}")
    public void updatePersonById(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Person newPerson){
        personService.updatePersonById(id, newPerson);
    }
}
