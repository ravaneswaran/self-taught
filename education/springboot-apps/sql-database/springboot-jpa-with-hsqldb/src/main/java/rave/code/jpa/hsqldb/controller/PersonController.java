package rave.code.jpa.hsqldb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rave.code.jpa.hsqldb.entity.Person;
import rave.code.jpa.hsqldb.request.PersonRequest;
import rave.code.jpa.hsqldb.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/create")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createdPerson = this.personService.createPerson(person);
        return ResponseEntity.status(200).body(createdPerson);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updatePerson(@RequestBody PersonRequest personRequest) {
        if (null != personRequest.getId()) {
            Person personToUpdate = this.personService.updatePerson(personRequest);
            return ResponseEntity.status(200).body(personToUpdate.toJsonString());
        } else {
            return ResponseEntity.status(404).body(String.format("Person not found for the id (%s)", personRequest.getId()));
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getPerson(@PathVariable String id) {
        Person person = this.personService.getPerson(id);
        if (null != person) {
            return ResponseEntity.status(200).body(person.toJsonString());
        } else {
            return ResponseEntity.status(404).body(String.format("Person not found for the id (%s)", person.getId()));
        }
    }

    @GetMapping("/get/all")
    public ResponseEntity<Iterable<Person>> getAllPersons() {
        return ResponseEntity.status(200).body(this.personService.getAllPerson());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable String id) {
        Person personToBeDeleted = this.personService.getPerson(id);
        if (null != personToBeDeleted) {
            this.personService.deletePerson(id);
            return ResponseEntity.status(200).body(String.format("DELETED PERSON : %s", personToBeDeleted.toJsonString()));
        } else {
            return ResponseEntity.status(404).body(String.format("Person not found for the id (%s)", personToBeDeleted.getId()));
        }
    }
}
