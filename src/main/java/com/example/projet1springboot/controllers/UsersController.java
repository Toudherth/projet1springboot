package com.example.projet1springboot.controllers;

import com.example.projet1springboot.models.User;
import com.example.projet1springboot.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping
    @RequestMapping("/users")
    public List<User> list(){
        return userRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/user/{id}")
    public  User getUser(@PathVariable Long id){
        if(userRepository.findById(id).isEmpty()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,
            "User with ID "+id+" not found");
        }
        return userRepository.getById(id);
    }

    @PostMapping
    @RequestMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User AddUser(@RequestBody final User user){

        return userRepository.saveAndFlush(user);
    }
    @DeleteMapping
    @RequestMapping(value = "/user/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        userRepository.deleteById(id);
    }
    @PutMapping
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable  Long id,@RequestBody User user){
      User existingUser = userRepository.getById(id);
        BeanUtils.copyProperties(user, existingUser, "user_id");
        return userRepository.saveAndFlush(existingUser);
    }
}
