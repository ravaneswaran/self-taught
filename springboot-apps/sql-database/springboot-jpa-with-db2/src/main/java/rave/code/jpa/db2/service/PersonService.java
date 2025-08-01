package rave.code.jpa.db2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rave.code.jpa.db2.entity.Person;
import rave.code.jpa.db2.repository.PersonRepository;
import rave.code.jpa.db2.request.PersonRequest;

import java.util.Date;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person person){
        return this.personRepository.save(person);
    }

    public Person updatePerson(PersonRequest personRequest){
        Optional<Person> optionalPerson = this.personRepository.findById(personRequest.getId());
        if(!optionalPerson.isEmpty()){
            Person person = optionalPerson.get();
            person.setFirstName(personRequest.getFirstName());
            person.setLastName(personRequest.getLastName());
            person.setEmailId(personRequest.getEmailId());
            person.setAge(personRequest.getAge());
            person.setModifiedDate(new Date());
            return this.personRepository.save(person);
        } else {
            return null;
        }
    }

    public Person getPerson(String id){
        Optional<Person> optionalPerson = this.personRepository.findById(id);
        if(!optionalPerson.isEmpty()){
            return optionalPerson.get();
        } else {
            return null;
        }
    }

    public Iterable<Person> getAllPerson(){
        return this.personRepository.findAll();
    }

    public void deletePerson(String id){
        this.personRepository.deleteById(id);
    }

}
