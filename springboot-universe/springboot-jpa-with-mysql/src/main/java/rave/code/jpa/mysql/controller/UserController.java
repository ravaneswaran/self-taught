package rave.code.jpa.mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rave.code.jpa.mysql.entity.User;
import rave.code.jpa.mysql.request.UserRequest;
import rave.code.jpa.mysql.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = this.userService.createUser(user);
        return ResponseEntity.status(200).body(createdUser);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody UserRequest userRequest) {
        if (null != userRequest.getId()) {
            User userToUpdate = this.userService.updateUser(userRequest);
            return ResponseEntity.status(200).body(userToUpdate.toJsonString());
        } else {
            return ResponseEntity.status(404).body(String.format("User not found for the id (%s)", userRequest.getId()));
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getUser(@PathVariable String id) {
        User user = this.userService.getUser(id);
        if (null != user) {
            return ResponseEntity.status(200).body(user.toJsonString());
        } else {
            return ResponseEntity.status(404).body(String.format("User not found for the id (%s)", user.getId()));
        }
    }

    @GetMapping("/get/all")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return ResponseEntity.status(200).body(this.userService.getAllUsers());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        User userToBeDeleted = this.userService.getUser(id);
        if (null != userToBeDeleted) {
            this.userService.deleteUser(id);
            return ResponseEntity.status(200).body(String.format("DELETED USER : %s", userToBeDeleted.toJsonString()));
        } else {
            return ResponseEntity.status(404).body(String.format("User not found for the id (%s)", userToBeDeleted.getId()));
        }
    }
}
