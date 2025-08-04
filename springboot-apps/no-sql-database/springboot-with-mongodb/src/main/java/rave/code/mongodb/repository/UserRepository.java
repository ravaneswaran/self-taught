package rave.code.mongodb.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rave.code.mongodb.documents.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // Custom query methods (if needed) can be defined here
}
