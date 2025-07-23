package rave.code.jpa.h2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rave.code.jpa.h2.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String>{}
