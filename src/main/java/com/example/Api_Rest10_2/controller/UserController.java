/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Api_Rest10_2.controller;

import com.example.Api_Rest10_2.model.User;
import com.example.Api_Rest10_2.repository.UserRepository;
import java.lang.System.Logger;
import java.util.List;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tarde
 */
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findUser(@PathVariable Long id) {
        Optional<User> usuario = userRepository.findById(id);

        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll(){
        List<User> usuarios = userRepository.findAll();
        return ResponseEntity.ok(usuarios);
        
    }
    
    @GetMapping("/edad/{yearBirth}")
    public ResponseEntity<List<User>> findByYear(@PathVariable Integer yearBirth){
        List<User> usuarios = userRepository.findByyearBirth(yearBirth);
        return ResponseEntity.ok(usuarios);
    }
    
   @GetMapping("/start/{prefix}")
   public ResponseEntity<List<User>> findByPrefix(@PathVariable String prefix){
       List<User> usuarios = userRepository.findByNameStartingWith(prefix);
       return ResponseEntity.ok(usuarios);
       
   }

}
