package rave.code.jpa.oracle.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rave.code.jpa.oracle.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String>{}
