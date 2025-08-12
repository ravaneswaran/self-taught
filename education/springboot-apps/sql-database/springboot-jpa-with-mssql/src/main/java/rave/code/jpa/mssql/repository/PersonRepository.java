package rave.code.jpa.mssql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rave.code.jpa.mssql.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String>{}
