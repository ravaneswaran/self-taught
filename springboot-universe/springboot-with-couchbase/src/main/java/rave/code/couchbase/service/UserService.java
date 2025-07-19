package rave.code.couchbase.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rave.code.couchbase.document.User;
import rave.code.couchbase.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public Iterable<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    public User findById(String id) {
        return this.userRepository.findById(id).get();
    }

    public void deleteUserById(String id) {
        this.userRepository.deleteById(id);
    }
}
