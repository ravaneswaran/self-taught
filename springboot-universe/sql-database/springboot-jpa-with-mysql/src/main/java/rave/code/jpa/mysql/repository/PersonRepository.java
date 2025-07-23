package rave.code.jpa.mysql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rave.code.jpa.mysql.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String>{}
