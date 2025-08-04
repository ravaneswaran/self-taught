package rave.code.jpa.derby.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rave.code.jpa.derby.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String>{}
