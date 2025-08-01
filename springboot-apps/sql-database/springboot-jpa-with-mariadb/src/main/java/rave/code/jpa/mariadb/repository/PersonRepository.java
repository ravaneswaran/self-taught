package rave.code.jpa.mariadb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rave.code.jpa.mariadb.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String>{}
