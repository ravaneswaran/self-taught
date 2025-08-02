package rave.code.jpa.sybase.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rave.code.jpa.sybase.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String>{}
