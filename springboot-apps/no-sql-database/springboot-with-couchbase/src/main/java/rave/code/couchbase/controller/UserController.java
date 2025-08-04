package rave.code.couchbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rave.code.couchbase.document.User;
import rave.code.couchbase.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user) {
        User savedUser = this.userService.saveUser(user);
        return ResponseEntity.status(200).body(savedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        User user = this.userService.findById(id);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("delete/{id}")
    public void deleteUser(@PathVariable String id) {
        this.userService.deleteUserById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return ResponseEntity.status(200).body(this.userService.findAllUsers());
    }
}
