package rave.code.jpa.db2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rave.code.jpa.db2.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String>{}
