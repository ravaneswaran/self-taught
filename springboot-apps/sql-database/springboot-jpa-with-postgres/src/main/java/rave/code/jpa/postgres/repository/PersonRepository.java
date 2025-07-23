package rave.code.jpa.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rave.code.jpa.postgres.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String>{}
