package rave.code.jpa.hsqldb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rave.code.jpa.hsqldb.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String>{}
