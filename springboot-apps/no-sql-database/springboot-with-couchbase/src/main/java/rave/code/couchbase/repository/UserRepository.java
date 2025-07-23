package rave.code.couchbase.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rave.code.couchbase.document.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {}
