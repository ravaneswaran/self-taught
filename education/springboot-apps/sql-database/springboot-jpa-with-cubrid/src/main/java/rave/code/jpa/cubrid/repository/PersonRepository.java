package rave.code.jpa.cubrid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rave.code.jpa.cubrid.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String>{}
