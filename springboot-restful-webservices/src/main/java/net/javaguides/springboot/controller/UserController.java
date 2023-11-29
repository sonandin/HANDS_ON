package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    //build create User Rest API
    @PostMapping
    public ResponseEntity<User> createUSer(@RequestBody User user){
        User savedUSer = userService.createUser(user);
        return new ResponseEntity<>(savedUSer, HttpStatus.CREATED);
    }

    //build get user by id Rest API\
    //http:localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    //build get All users rest Api
    //http:localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    //build update user REST API
    //http://localhost:8080/api/users/1
    @PutMapping("{id}")

    public ResponseEntity<User> updatedUser(@PathVariable Long userId,
                                            @RequestBody User user){
        user.setId(userId);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
