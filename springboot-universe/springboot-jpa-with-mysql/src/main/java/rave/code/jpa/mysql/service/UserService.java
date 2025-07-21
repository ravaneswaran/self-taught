package rave.code.jpa.mysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rave.code.jpa.mysql.entity.User;
import rave.code.jpa.mysql.repository.UserRepository;
import rave.code.jpa.mysql.request.UserRequest;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return this.userRepository.save(user);
    }

    public User updateUser(UserRequest userRequest){
        Optional<User> optionalUser = this.userRepository.findById(userRequest.getId());
        if(!optionalUser.isEmpty()){
            User user = optionalUser.get();
            user.setFirstName(userRequest.getFirstName());
            user.setLastName(userRequest.getLastName());
            user.setEmailId(userRequest.getEmailId());
            user.setAge(userRequest.getAge());
            user.setModifiedDate(new Date());
            return this.userRepository.save(user);
        } else {
            return null;
        }
    }

    public User getUser(String id){
        Optional<User> optionalUser = this.userRepository.findById(id);
        if(!optionalUser.isEmpty()){
            return optionalUser.get();
        } else {
            return null;
        }
    }

    public Iterable<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public void deleteUser(String id){
        this.userRepository.deleteById(id);
    }

}
