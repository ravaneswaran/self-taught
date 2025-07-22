package rave.code.jpa.sqlite.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rave.code.jpa.sqlite.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String>{}
