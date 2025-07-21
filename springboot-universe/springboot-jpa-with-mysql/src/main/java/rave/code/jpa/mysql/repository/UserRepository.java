package rave.code.jpa.mysql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rave.code.jpa.mysql.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{}
